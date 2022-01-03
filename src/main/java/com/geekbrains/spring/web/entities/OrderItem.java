package com.geekbrains.spring.web.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @NonNull
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    @NonNull
    private Integer quantity;

    @Column(name = "price_per_product")
    @NonNull
    private Integer pricePerProduct;

    @Column(name = "price")
    @NonNull
    private Integer price;

}
