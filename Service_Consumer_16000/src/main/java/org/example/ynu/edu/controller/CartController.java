package org.example.ynu.edu.controller;

import jakarta.annotation.Resource;
import org.example.ynu.edu.entity.CommonResult;
import org.example.ynu.edu.entity.User;
import org.example.ynu.edu.feign.ServiceProviderService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){
        CommonResult<User> result = serviceProviderService.getUserById(userId);
        return result;
    }

    @PostMapping("/saveUserByRequestBody")
    public CommonResult<User> saveUserByRequestBody(@RequestBody User user){
        CommonResult<User> result =serviceProviderService.saveUserByRequestBody(user);
        return result;
    }

    @PutMapping("/putUser")
    public CommonResult<User> putUser(@RequestBody User user){
        serviceProviderService.putUser(user);
        return null;
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public CommonResult<User> deleteUserById(@PathVariable("userId") Integer userId){
        serviceProviderService.deleteUserById(userId);
        return null;
    }
}
