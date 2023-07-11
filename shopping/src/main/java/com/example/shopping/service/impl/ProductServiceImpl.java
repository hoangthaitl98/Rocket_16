package com.example.shopping.service.impl;

import com.example.shopping.dto.ProductDto;
import com.example.shopping.entity.Product;
import com.example.shopping.repository.CategoryRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.service.ProductService;
import com.example.shopping.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private StringUtils stringUtils = new StringUtils();

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product addProduct(ProductDto productDto) {
        Product addedProduct = new Product();
        addedProduct.setName(productDto.getName());
        addedProduct.setPrice(productDto.getPrice());
        addedProduct.setDescription(productDto.getDescription());
        addedProduct.setCategory(categoryRepository.findById(productDto.getCategoryId()).get());
        addedProduct.setSlug(stringUtils.createSlug(productDto.getName()));
        return productRepository.save(addedProduct);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product productUpdate = productRepository.findById(id).get();
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

    @Override
    public Page<Product> getProductByCategory(int categoryId, Pageable pageable) {

        List<Product> productList = categoryRepository.findById(categoryId).get().getProducts();
        if (pageable.getOffset() >= productList.size()) {
            return Page.empty();
        }

        int startIndex = (int) pageable.getOffset();
        int endIndex = (pageable.getOffset() + pageable.getPageSize() > productList.size()
                ? productList.size()
                : (int) pageable.getOffset() + pageable.getPageSize());

        return new PageImpl<>(productList.subList(startIndex, endIndex), pageable, productList.size());

    }
}
