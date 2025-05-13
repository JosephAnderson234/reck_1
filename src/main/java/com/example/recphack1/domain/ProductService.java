package com.example.recphack1.domain;

import com.example.recphack1.infrastructure.OrderRepository;
import com.example.recphack1.infrastructure.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductoRepository productoRepository;
    private OrderRepository orderRepository;

    public void eliminarProducto(List<Producto> productos){

        for (Producto producto : productos) {

            Producto productoExistente = productoRepository.findById(producto.getId()).orElse(null);
            productoExistente.setStock(producto.getStock()-1);
            productoRepository.save(productoExistente);
        }


    }
    public int eliminarProductoId(Long id){



        Producto productoExistente = productoRepository.findById(id).orElse(null);
        productoExistente.setStock(productoExistente.getStock()-1);
        productoRepository.save(productoExistente);

        return productoExistente.getStock();

    }

}
