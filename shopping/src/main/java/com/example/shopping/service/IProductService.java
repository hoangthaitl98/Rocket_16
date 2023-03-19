package com.example.shopping.service;

import com.example.shopping.body.ProductBody;
import com.example.shopping.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllProduct(Pageable pageable);

    Product addProduct(ProductBody productBody);

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);

    Product getById(String id);
}
