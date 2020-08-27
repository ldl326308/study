package com.lemon.service.impl;

import com.lemon.bean.UserAddress;
import com.lemon.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 1、服务提供者注册到注册中心
 * 2、让服务消费者去注册中心订阅服务
 */
public class UserServiceImpl2 implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("调用UserServiceImpl 2 版本");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserAddress userAddress = new UserAddress(1, "江西省赣州市", "1", "王也", "17318071854", "yes");
        UserAddress userAddress1 = new UserAddress(2, "广东省深圳市", "1", "Uzi", "18517261354", "no");

        return Arrays.asList(userAddress, userAddress1);
    }
}
