package com.example.shopping.controller;

import com.example.shopping.dto.ProductDto;
import com.example.shopping.entity.Product;
import com.example.shopping.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "get all product")
    public ResponseEntity<?> getAllProduct(Pageable pageable,
                                           @RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "3") int size) {
        Page<Product> products = productService.getAllProduct(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/")
    @ApiOperation(value = "add new product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product.getId(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "update product by id")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete product")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByCategory/{categoryId}")
    public ResponseEntity<?> getByCategory(@PathVariable int categoryId, Pageable pageable,
                                           @RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "3") int size) {
        return new ResponseEntity<>(productService.getProductByCategory(categoryId, pageable), HttpStatus.OK);
    }
}
