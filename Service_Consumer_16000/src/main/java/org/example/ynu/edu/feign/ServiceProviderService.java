package org.example.ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.example.ynu.edu.entity.CommonResult;
import org.example.ynu.edu.entity.User;

@FeignClient("provider-server") //这启动类中的EnableReignClien相匹配使用
//这个是让provider-server提供服务的客户端,能够找到名叫provider-server的应用所定义的controller
public interface ServiceProviderService {
    //服务提供者的服务,把定义的controller头两行抄下来就行。记得把user前缀补上
    @GetMapping("/user/getUserById/{userId}")
    CommonResult<User> getUserById(@PathVariable("userId") Integer userId);

    @PostMapping("/user/saveUserByRequestBody")
    public CommonResult<User> saveUserByRequestBody(@RequestBody User user);

    @PutMapping("/user/putUser")
    public CommonResult<User> putUser(@RequestBody User user);

    @DeleteMapping("/user/deleteUserById/{userId}")
    public CommonResult<User> deleteUserById(@PathVariable("userId") Integer userId);
}
