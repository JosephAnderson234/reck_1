package com.example.recphack1.domain;

import jakarta.persistence.*;
import com.example.recphack1.domain.Order;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    private String name;
    private Double price;
    private Integer stock;

    @ManyToOne
    private Order order;


}
