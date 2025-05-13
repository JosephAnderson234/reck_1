package com.example.recphack1.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @OneToMany(mappedBy = "order")
    private List<Producto> products;


    public void addProduct(Producto product) {
        if (products == null) {
            products = new ArrayList<>();
        }

        products.add(product);
        product.setOrder(this);
    }
}
