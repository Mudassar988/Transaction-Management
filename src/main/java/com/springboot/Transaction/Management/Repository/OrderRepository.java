package com.springboot.Transaction.Management.Repository;

import com.springboot.Transaction.Management.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
