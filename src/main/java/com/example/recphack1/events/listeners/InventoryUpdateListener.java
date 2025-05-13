package com.example.recphack1.events.listeners;

import com.example.eventosconwhereby.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryUpdateListener {
    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("📦 Actualizando inventario por los productos: {}", event.getOrder().getProductos());
    }
}