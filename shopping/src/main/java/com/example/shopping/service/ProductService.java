package com.example.shopping.service;

import com.example.shopping.dto.ProductDto;
import com.example.shopping.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAllProduct(Pageable pageable);

    Product addProduct(ProductDto productDto);

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);

    Product getById(String id);

    Page<Product> getProductByCategory(int categoryId, Pageable pageable);
}
