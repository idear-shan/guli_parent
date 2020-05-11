package com.atguigu.eduservice.config;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handException(Class<Exception> e) {
        Map<String, Object> map = new HashMap<>();
        map.put("ss", 500);
        map.put("error", e.toString());

        return map;
    }
    //特定异常
    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Map<String, Object> ArithmeticException(ArithmeticException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("ss", 500);
        map.put("ArithmeticException", e.toString());
        log.error(e.getMessage());//写出异常日志
        return map;
    }

}
