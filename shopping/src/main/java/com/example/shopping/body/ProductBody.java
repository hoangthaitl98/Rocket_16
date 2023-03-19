package com.example.shopping.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBody {
    private String name;
    private int price;
    private String description;
    private int categoryId;
}
