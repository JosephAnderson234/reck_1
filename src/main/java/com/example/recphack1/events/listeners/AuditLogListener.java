package com.example.recphack1.events.listeners;



import com.example.recphack1.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogListener {

    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("📝 Registrando pedido en logs: ID={}, Email={}, Productos={}",
                event.getOrder().getId(),
                event.getOrder().getEmail(),
                event.getOrder().getProductos());
    }
}
