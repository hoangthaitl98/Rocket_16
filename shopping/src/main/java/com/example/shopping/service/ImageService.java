package com.example.shopping.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.example.shopping.entity.Image;
import com.example.shopping.entity.Product;
import org.springframework.web.multipart.MultipartFile;


public interface ImageService {
    void uploadImage(MultipartFile[] image, String productId) throws IOException;

    File dowwnloadImage(String nameImage) throws IOException;

    String getImgNameByID(short id);

}
