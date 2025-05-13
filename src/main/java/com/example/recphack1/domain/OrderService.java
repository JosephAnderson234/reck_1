package com.example.recphack1.domain;

import com.example.recphack1.events.OrderCreatedEvent;
import com.example.recphack1.infrastructure.OrderRepository;
import com.example.recphack1.infrastructure.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void createOrder(Order order) {


        // Guardar el pedido en el repositorio
        Order orderN = orderRepository.save(order);

        // Publicar el evento después de guardar el pedido
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(this, orderN));
    }


}
