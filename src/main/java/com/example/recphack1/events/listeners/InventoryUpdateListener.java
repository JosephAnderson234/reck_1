package com.example.recphack1.events.listeners;

import com.example.recphack1.domain.ProductService;
import com.example.recphack1.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryUpdateListener {

    @Autowired
    private ProductService productService;

    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("📦 Actualizando inventario por los productos: {}", event.getOrder().getProducts());

        if (event.getOrder().getProducts() != null) {
            event.getOrder().getProducts().forEach(product -> {
                log.info(product.getName() + " ahora tiene " + productService.eliminarProductoId(product.getId()) + " en stock");
            });
        } else {
            log.warn("El pedido no contiene productos.");
        }
    }
}