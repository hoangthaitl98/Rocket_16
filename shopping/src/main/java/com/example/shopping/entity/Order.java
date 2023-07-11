package com.example.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order", catalog = "shopping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname", length = 50)
    private String fullname;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phoneNumber", length = 50)
    private String phoneNumber;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus status;
}
