package com.lemon.service.impl;

import com.lemon.bean.UserAddress;
import com.lemon.service.OrderService;
import com.lemon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;

    public OrderServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public void initOrder(String userId) {
        System.out.println("userId---------" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
    }
}
