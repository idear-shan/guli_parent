//package com.atguigu.eduservice.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.nio.charset.Charset;
//import java.util.List;
//
//@Configuration
//public class MyInterceptorConfig extends WebMvcConfigurationSupport {
//    //        addPathPatterns添加需要拦截的命名空间；
////        excludePathPatterns添加排除拦截命名空间
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new Myinterceptor()).addPathPatterns("/**").excludePathPatterns("/register").excludePathPatterns("/login").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//
//    }
//
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }
//
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        //解决中文乱码
//        converters.add(responseBodyConverter());
//        //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no convertter for return value of type
//        converters.add(messageConverter());
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter messageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(getObjectMapper());
//        return converter;
//    }
//
//    @Bean
//    public ObjectMapper getObjectMapper() {
//        return new ObjectMapper();
//    }
//
//
//}
