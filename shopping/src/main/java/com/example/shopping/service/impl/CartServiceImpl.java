package com.example.shopping.service.impl;

import com.example.shopping.entity.Cart;
import com.example.shopping.entity.CartItem;
import com.example.shopping.entity.Product;
import com.example.shopping.entity.User;
import com.example.shopping.repository.CartRepository;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart getByUser(String userId) {
        Cart cart = userRepository.findById(userId).get().getCart();
        return cart;
    }

    @Override
    public Cart createCart(String userId) {
        User user = userRepository.findById(userId).get();
        if (user.getCart() == null) {
            Cart cart = new Cart();
            cart.setUser(user);
            return cartRepository.save(cart);
        } else {
            return null;
        }
    }

    @Override
    public Cart addProductToCart(int cartId, String productId) {
        Cart cart = cartRepository.getById(cartId);
        Product product = productRepository.getById(productId);
        List<CartItem> cartItemList = cart.getCartItems();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(1);
        cartItemList.add(cartItem);
        return cart;
    }
}
