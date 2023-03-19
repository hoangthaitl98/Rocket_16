package com.example.shopping.controller;

import com.example.shopping.service.ImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v2/image", produces = { "application/json" },
        consumes = { "application/json" })
@CrossOrigin("*")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/upload/{productId}", consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "upload product's image")
    public ResponseEntity<?> upLoadImage(@RequestParam MultipartFile[] images, @PathVariable String productId, HttpServletRequest request) throws IOException {
        try {
            imageService.uploadImage(images, productId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/download/{nameImage}")
    public ResponseEntity<?> downloadImage(@PathVariable String nameImage) throws IOException {

        // TODO validate

        File imageFile = imageService.dowwnloadImage(nameImage);
        InputStreamResource imageStream = new InputStreamResource(new FileInputStream(imageFile));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", nameImage));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(imageFile.length())
                .contentType(MediaType.parseMediaType("application/txt"))
                .body(imageStream);
    }
}
