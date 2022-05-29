package com.example.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="`product`", catalog = "shopping")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private static final long serialVersionUID  = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @Column(name = "name", length = 50)
    private String productName;

    @Column(name = "imgLink", length = 255)
    private String imgLink;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
