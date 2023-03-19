package com.example.shopping.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBody {
    private String fullname;

    private String email;

    private String phoneNumber;

    private String address;

    private String[] productIds;

    private int totalPrice;
}
