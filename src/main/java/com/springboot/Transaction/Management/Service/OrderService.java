package com.springboot.Transaction.Management.Service;

import com.springboot.Transaction.Management.Dto.OrderRequest;
import com.springboot.Transaction.Management.Dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder_ServiceInterface(OrderRequest orderRequest);

}
