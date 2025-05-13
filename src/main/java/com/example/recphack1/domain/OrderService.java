package com.example.recphack1.domain;

import com.example.recphack1.events.OrderCreatedEvent;
import com.example.recphack1.infrastructure.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void createOrder(Order order) {

        applicationEventPublisher.publishEvent(new OrderCreatedEvent(this, order));

        orderRepository.save(order);

    }


}
