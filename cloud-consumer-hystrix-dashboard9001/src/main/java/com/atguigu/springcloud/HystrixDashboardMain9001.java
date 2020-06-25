package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author theone
 * @Date 2020/6/14 11:32
 * @Version 1.0
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMain9001 {
        public static void main(String[] args) {
                    SpringApplication.run(HystrixDashboardMain9001.class, args);
            }
}
