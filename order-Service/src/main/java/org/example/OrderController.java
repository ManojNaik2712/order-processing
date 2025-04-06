package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderCreateRequest orderCreateRequest){
        OrderEntity savedOrderEntity =orderService.saveOrder(orderCreateRequest);
        return new ResponseEntity<>(savedOrderEntity,HttpStatus.CREATED);
    }

    @GetMapping("/getOrder")
    public OrderEntity getOrderDetails(@RequestParam int id){
        return orderService.getOrders(id);
    }


}
