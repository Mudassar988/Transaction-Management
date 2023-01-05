package com.springboot.Transaction.Management.Service;

import com.springboot.Transaction.Management.Dto.OrderRequest;
import com.springboot.Transaction.Management.Dto.OrderResponse;
import com.springboot.Transaction.Management.Entity.Order;
import com.springboot.Transaction.Management.Entity.Payment;
import com.springboot.Transaction.Management.Exception.PaymentException;
import com.springboot.Transaction.Management.Repository.OrderRepository;
import com.springboot.Transaction.Management.Repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    @Transactional
    public OrderResponse placeOrder_ServiceInterface(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw  new PaymentException("Payment type not supported");
        }

        payment.setId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(orderResponse.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return  orderResponse;

    }

}
