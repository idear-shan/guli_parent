//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2
//public class Swagger {
//    @Bean
//    public Docket dockets(Environment environment) {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .groupName("shan");
//    }
//
//    //配置swagge的bean实例
//    @Bean
//    public Docket docket(Environment environment) {
//        //设置要显示的swgger环境
//        Profiles of = Profiles.of("dev","test");
//        boolean b = environment.acceptsProfiles(of);
////扫描接口包
//        //RequestHandlerSelectors 配置扫描接口的方式
//        //basePackage //扫描包
//        //any() 扫描全部
//        //only()//不扫描
////withClassAnnotation()扫描注解
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .groupName("kk")
//                .enable(b)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.atguigu"))
//                .paths(PathSelectors.any()).build();//工厂
//    }
//
//    private ApiInfo apiInfo() {
//        //作者信息
//        Contact contact = new Contact("闪峰", "http://127.0.0.1:8848/BMT/index.html ", "2228202165@qq.com");
//        return new ApiInfo(
//                "api文档",
//                "越努力，越幸运",
//                "1.0",
//                "http://127.0.0.1:8848/BMT/index.html",
//                contact,
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList());
//    }
//
//}
