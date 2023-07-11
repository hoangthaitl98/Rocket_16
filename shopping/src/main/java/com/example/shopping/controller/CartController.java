package com.example.shopping.controller;

import com.example.shopping.entity.Cart;
import com.example.shopping.service.CartService;
import com.example.shopping.service.UserService;
import com.example.shopping.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v2/cart")
public class CartController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCartByUser(HttpServletRequest request) {
        String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
        Cart cart = cartService.getByUser(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createCart(HttpServletRequest request) {
        String userId = jwtUtils.getUserIdFromJWT(request.getHeader("Authorization").substring(7));
        Cart cart = cartService.createCart(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{cartId}/addToCart/{productId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addProductToCart(@PathVariable int cartId, @PathVariable String productId) {
        Cart cart = cartService.addProductToCart(cartId, productId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
