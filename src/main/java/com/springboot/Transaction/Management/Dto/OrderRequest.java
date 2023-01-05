package com.springboot.Transaction.Management.Dto;

import com.springboot.Transaction.Management.Entity.Order;
import com.springboot.Transaction.Management.Entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

        private Order order;
        private Payment payment;

}
