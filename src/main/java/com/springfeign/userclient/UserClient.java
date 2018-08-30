package com.springfeign.userclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : xujunbao
 * @ClassName com.springfeign.userclient
 * @description  增加用户调用接口interface
 * @Create Date : 2018/8/30
 */
@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("/user1")
    String getUser();
}
