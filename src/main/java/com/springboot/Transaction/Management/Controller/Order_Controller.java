package com.springboot.Transaction.Management.Controller;

import com.springboot.Transaction.Management.Dto.OrderRequest;
import com.springboot.Transaction.Management.Dto.OrderResponse;
import com.springboot.Transaction.Management.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class Order_Controller {
    private OrderService orderService;

    public Order_Controller(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        return  ResponseEntity.ok(orderService.placeOrder_ServiceInterface(orderRequest));
    }
}
