package com.springboot.Transaction.Management.Repository;

import com.springboot.Transaction.Management.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
