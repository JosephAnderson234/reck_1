package com.example.recphack1.user.infrastructure;

import com.example.recphack1.user.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
