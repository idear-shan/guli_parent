//package com.atguigu.eduservice.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
//public class Myinterceptor implements HandlerInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(Myinterceptor.class);
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        String methodName = method.getName();
//        logger.info("拦截方法", methodName);
//        // 返回 true 才会继续执行，返回 false 则取消当前请求
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        logger.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        logger.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图");
//    }
//
//
//}
