package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 测试
 * @author chengdongyi
 * @date 2019/7/1 14:57
 */
@RestController
public class TestController {

    @GetMapping("/getName")
    public String getName() {

        return "zhangsan";

    }

    @PostMapping("/test")
    public String test(@RequestBody User user) {

        System.out.println(JSON.toJSONString(user));
        return "Success";

    }

    @PostMapping("/hello")
    public String hello(@RequestBody User user) {

        System.out.println(JSON.toJSONString(user));
        return "Success";

    }
}
