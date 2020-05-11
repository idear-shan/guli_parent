package com.atguigu.eduservice.controller;

import com.atguigu.common.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin//解决跨域
public class EduloginController {
    /**
     * 登录
     */
    @PostMapping("login")
    public CommonResult login(){
        Map map =new HashMap();
        map.put("token","admin");
        return new CommonResult(20000,"成功",map);
    }
    @GetMapping("info")
    public CommonResult info(){
        Map map =new HashMap();
        map.put("roles","admin");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return new CommonResult(20000,"成功",map);
    }
}
