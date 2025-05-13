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
            productoRepository.delete(producto);
        }


    }

}
