package com.example.recphack1.domain;

import jakarta.persistence.*;
import com.example.recphack1.domain.Order;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private Double price;
    private Integer stock;

    @ManyToOne
    private Order order;


}
