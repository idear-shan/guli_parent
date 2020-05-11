package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class Educonfig {
//    //乐观锁
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
//        return new OptimisticLockerInterceptor();
//    }
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){

        return new PaginationInterceptor();
    }
    //逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector(){

        return new LogicSqlInjector();
    }
//    @Bean
//    @Profile({"dev","test"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor pr = new PerformanceInterceptor();
//        pr.setMaxTime(200);//毫秒 超过sql不执行
//        pr.setFormat(true);
//        return pr;
//    }
}
