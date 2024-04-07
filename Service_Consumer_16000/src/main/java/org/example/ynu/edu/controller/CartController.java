package org.example.ynu.edu.controller;

import jakarta.annotation.Resource;
import org.example.ynu.edu.entity.CommonResult;
import org.example.ynu.edu.entity.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    /*@Autowired
    private */
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){
        //通过服务提供者名（provider-server）获取Eureka server上的服务注册列表（因为存在同名的服务，所以获取到的是列表）
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        CommonResult<User> result = restTemplate.getForObject(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/getUserById/"+userId.toString(),
                CommonResult.class
        );
        return result;
    }

    @PostMapping("/saveUserByRequestBody")
    public CommonResult<User> saveUserByRequestBody(@RequestBody User user){
        //通过服务提供者名（provider-server）获取Eureka server上的服务注册列表（因为存在同名的服务，所以获取到的是列表）
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        System.out.println("http://"+instance.getHost()+":"+instance.getPort()+"/user/saveUser");
        CommonResult<User> result = restTemplate.postForObject(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/saveUserByRequestBody",
                user,
                CommonResult.class
        );
        return result;
    }

    @PostMapping("/saveUserByRequestParam_forbid")
    public CommonResult<User> saveUserByRequestParam(@RequestParam("userId") Integer userId){
        //通过服务提供者名（provider-server）获取Eureka server上的服务注册列表（因为存在同名的服务，所以获取到的是列表）
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        System.out.println("http://"+instance.getHost()+":"+instance.getPort()+"/user/saveUserByRequestParam");
        //postForObject方法 只支持接收一个对象，不能是RequestParam
        CommonResult<User> result = restTemplate.postForObject(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/saveUserByRequestParam",
                userId,
                CommonResult.class
        );
        return result;
    }
    @PutMapping("/putUser")
    public CommonResult<User> putUser(@RequestBody User user){
        //通过服务提供者名（provider-server）获取Eureka server上的服务注册列表（因为存在同名的服务，所以获取到的是列表）
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        System.out.println("http://"+instance.getHost()+":"+instance.getPort()+"/user/putUser");
        //RestTemplate.put没有返回值，所以这个东西是否被调用，可以看11000的输出窗口，使用RestTemplate.exchange方法参数改为put，会报错
         restTemplate.put(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/putUser",
                user
        );
        return null;
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public CommonResult<User> deleteUserById(@PathVariable("userId") Integer userId){
        //通过服务提供者名（provider-server）获取Eureka server上的服务注册列表（因为存在同名的服务，所以获取到的是列表）
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for(ServiceInstance si : instanceList){
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        System.out.println("http://"+instance.getHost()+":"+instance.getPort()+"/user/deleteUserById");
        restTemplate.delete(
                "http://"+instance.getHost()+":"+instance.getPort()+"/user/deleteUserById/"+userId.toString()
        );
        return null;
    }
}
