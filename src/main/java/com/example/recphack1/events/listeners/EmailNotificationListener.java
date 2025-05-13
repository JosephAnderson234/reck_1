package com.example.recphack1.events.listeners;

import com.example.recphack1.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailNotificationListener {

    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        String email = event.getOrder().getEmail();
        log.info("📧 Enviando correo de confirmación a: {}", email);
    }
}