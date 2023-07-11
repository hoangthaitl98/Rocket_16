package com.example.shopping.service;

import com.example.shopping.entity.Cart;

public interface CartService {
    Cart getByUser(String userId);

    Cart createCart(String userId);

    Cart addProductToCart(int cartId, String productId);
}
