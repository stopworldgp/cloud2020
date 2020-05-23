package com.atguigu.springcloud;

import com.atguigu.myselfrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import javax.print.attribute.standard.OrientationRequested;

/**
 * @Author theone
 * @Date 2020/4/26 21:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name ="consul-provider-payment",configuration = MySelfRule.class)
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
