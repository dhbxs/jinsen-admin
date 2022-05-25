package top.dhbxs.jinsen.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.dhbxs.jinsen.admin.config.interceptor.JwtInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/users", "/users/getAll"); // 排除/users请求
    }
}
