package com.springboot.demo.config;

import com.springboot.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：archer
 * @date ：Created in 2022/7/13 16:38
 * @description：
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 要这个 D:\data\picture\ 而不是这个D:\data\picture
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "D:\\data\\picture\\");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                //是否允许证书
                .allowCredentials (true)
                .allowedHeaders("*");

//        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://localhost:8080")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*")
//                .maxAge(3600);
    }
}
