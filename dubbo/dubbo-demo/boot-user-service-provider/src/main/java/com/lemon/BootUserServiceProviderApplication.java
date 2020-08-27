package com.lemon;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBoot与Dubbo整合的三种方式：
 *  1、导入dubbo-starter，在application.properties配置属性，
 *      使用@Service【暴露服务】，使用@Reference【引用服务】
 *      @Enableubbo 开启Dubbo注解
 *  2、保留dubbo xml配置文件；@ImportResource导入xml配置文件
 *  3、将组件手动创建，创建配置类，使用@Configuration
 */

//@EnableDubbo(scanBasePackages = "com.lemon") // 开启基于注解的Dubbo功能
//@ImportResource(locations = "classpath:provider.xml")  // 导入xml配置文件
@DubboComponentScan(basePackages = "com.lemon")
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
