package com.example.shopping.service.impl;

import com.example.shopping.entity.Image;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ImageRepository;
import com.example.shopping.service.ImageService;
import com.example.shopping.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private ImageUtils imageUtils = new ImageUtils();
    private String linkFolder = "/Users/hoangthai/Desktop/Rocket_16/shopping/src/main/resources/image/";

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void uploadImage(MultipartFile[] images, String productId) throws IOException {
        Product productUpdate = productRepository.getById(productId);
        System.out.print(productUpdate.getId());
        List<Image> imagesProduct = productUpdate.getImages();

        for (int i = 0; i < images.length; i++) {
            String nameImage = new Date().getTime() + "." + imageUtils.getFormatFile(images[i].getOriginalFilename());
            String path = linkFolder + nameImage;
            imageUtils.createNewMultiPartFile(path, images[i]);
            Image imageResponse = new Image();
            imageResponse.setFileName(nameImage);
            imageResponse.setSize(images[i].getSize());
            imageResponse.setType(images[i].getContentType());
            imageResponse.setViewUrl(path);
            Image newImage = imageRepository.save(imageResponse);
            imagesProduct.add(newImage);
        }
        productUpdate.setImages(imagesProduct);
        productRepository.save(productUpdate);
        // return link uploaded file
    }

    @Override
    public File dowwnloadImage(String nameImage) throws IOException {
        String path = linkFolder + nameImage;
        return new File(path);
    }

    @Override
    public String getImgNameByID(short id) {
        return null;
    }
}
