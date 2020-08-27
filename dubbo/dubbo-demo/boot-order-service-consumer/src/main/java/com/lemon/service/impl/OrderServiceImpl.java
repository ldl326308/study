package com.lemon.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lemon.bean.UserAddress;
import com.lemon.service.OrderService;
import com.lemon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    // zookeeper 宕机依然可以通过“本地缓存”提供服务，
    // 配置url后，不需要zookeeper依然可以提供服务 => Dubbo直连，如果配置了url，将直接绕过注册中心
    // 配置loadbalance，选择负载均衡机制
    @Reference  //(loadbalance = "random") //(url = "127.0.0.1:20887")  // Dubbo直连
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId---------" + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
