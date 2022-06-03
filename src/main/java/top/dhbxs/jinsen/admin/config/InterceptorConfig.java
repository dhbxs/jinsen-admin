package top.dhbxs.jinsen.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.dhbxs.jinsen.admin.config.interceptor.JwtInterceptor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        HandlerInterceptor jwtInterceptor = new JwtInterceptor();

        List<String> patterns=new ArrayList<>();
        patterns.add("/users/**");
        patterns.add("/users/update");
        patterns.add("/users/delete");
        patterns.add("/wild-order/getAll");
        patterns.add("/file/**");
        patterns.add("/error");
        patterns.add("/static/**");
        patterns.add("/users/page");
        patterns.add("/wild-order/**");

        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns(patterns);
    }
}
