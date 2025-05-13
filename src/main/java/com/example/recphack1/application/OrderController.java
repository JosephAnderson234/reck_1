package com.example.recphack1.application;


import com.example.recphack1.domain.Order;
import com.example.recphack1.domain.OrderService;
import com.example.recphack1.events.OrderCreatedEvent;
import com.example.recphack1.events.listeners.InventoryUpdateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping
    public void createOrder(@RequestBody Order order) {

        eventPublisher.publishEvent(new OrderCreatedEvent(this, order));


        orderService.createOrder(order);
    }


}
