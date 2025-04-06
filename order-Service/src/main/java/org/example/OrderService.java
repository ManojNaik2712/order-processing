package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public OrderEntity saveOrder(OrderCreateRequest orderCreateRequest) {
        OrderEntity savedOrderEntity =orderCreateRequest.toOrder();
         return  orderRepo.save(savedOrderEntity);
    }

    public OrderEntity getOrders(int id) {
        return orderRepo.findById(id).get();
    }
}
