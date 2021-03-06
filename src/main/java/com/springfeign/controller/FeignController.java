package com.springfeign.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springfeign.userclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xujunbao
 * @ClassName com.springribbon.controller
 * @description
 * @Create Date : 2018/8/29
 */
@RestController
public class FeignController {

    @Autowired
    UserClient userClient;

    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback")
    public String getUser() {
        return userClient.getUser();
    }

    public String fallback(){
        return "服务访问失败，请稍后重试";
    }

}
