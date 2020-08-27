package com.lemon.service.impl;

import com.lemon.bean.UserAddress;
import com.lemon.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 本地存根，在调用远程方法时，先在本地对参数进行一个验证，再决定是否调用
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    /**
     * 获取远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub 本地存根被调用.....");
        if (!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
