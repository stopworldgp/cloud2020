package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author theone
 * @Date 2020/4/7 23:54
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****插入结果："+result);
        System.out.println(12344);
        if (result!=null){
            return new CommonResult(200,"查询成功",result);
        }else {
            return new CommonResult(444,"查询失败，查询id："+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for(String element: services){
            log.info("****element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
