package com.example.shopping.service.impl;

import com.example.shopping.body.ProductBody;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product addProduct(ProductBody productBody) {
        Product addedProduct = new Product();
        addedProduct.setName(productBody.getName());
        addedProduct.setPrice(productBody.getPrice());
        addedProduct.setDescription(productBody.getDescription());
        addedProduct.setCategory(categoryRepository.getById(productBody.getCategoryId()));
        return productRepository.save(addedProduct);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product productUpdate = productRepository.getById(id);
        if (productUpdate == null) {
            return null;
        }
        productUpdate.setName(product.getName());
        productUpdate.setDescription(product.getDescription());
        productUpdate.setPrice((productUpdate.getPrice()));
        return productRepository.save(productUpdate);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


    @Override
    public Product getById(String id) {
        return productRepository.findById(id).get();
    }
}
