package com.lemon.config;

import com.alibaba.dubbo.config.*;
import com.lemon.service.UserService;
import com.lemon.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    /**
     *
     *     <!-- 声明需要暴露的服务接口 -->
     *     <dubbo:service timeout="0" interface="com.lemon.service.UserService" ref="userService01" version="1.0.0" ></dubbo:service>
     *
     *     <!-- 和本地bean一样实现服务 -->
     *     <bean id="userService01" class="com.lemon.service.impl.UserServiceImpl"  />
     */

//    <!-- 提供方应用信息，用于计算依赖关系 -->
//    <dubbo:application name="boot-user-service-provider"/>
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

//    <!-- 使用zookeeper广播注册中心暴露服务地址 -->
//    <!--    <dubbo:registry address="zookeeper://127.0.0.1:2181"></dubbo:registry>-->
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

//     <!-- 用dubbo协议在20880端口暴露服务 -->
//     <dubbo:protocol name="dubbo" port="20883" />
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20889);
        return protocolConfig;
    }

//    <!-- 声明需要暴露的服务接口 -->
//    <dubbo:service timeout="0" interface="com.lemon.service.UserService" ref="userService01" version="1.0.0" ></dubbo:service>
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        // 配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        // 将method的设置关联到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);

        return serviceConfig;
    }


}
