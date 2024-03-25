package org.example.ynu.edu.controller;

import jakarta.annotation.Resource;
import org.example.ynu.edu.entity.CommonResult;
import org.example.ynu.edu.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
public class CartController {
    /*@Autowired
    private */
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getCartById/{userId}")
    public CommonResult<User> getCartById(@PathVariable("userId") Integer userId){
        CommonResult<User> result = restTemplate.getForObject(
                "http://localhost:11001/user/getUserById/"+userId.toString(),//这里的url需要写完整
                CommonResult.class
        );
        return result;
    }
}
