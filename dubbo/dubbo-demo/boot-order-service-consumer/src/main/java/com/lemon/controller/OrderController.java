package com.lemon.controller;

import com.lemon.bean.UserAddress;
import com.lemon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/initOrder")
    public List<UserAddress> getUserAddressList(@RequestParam("userId") String userId){
        return orderService.initOrder(userId);
    }

}
