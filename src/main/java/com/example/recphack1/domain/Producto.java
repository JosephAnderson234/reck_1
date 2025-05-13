package com.example.recphack1.user.domain;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    private String name;
    private Double price;
    private Integer stock;

    @OneToMany(mappedBy = "products")
    private Order order;


}
