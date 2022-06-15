package kr.ac.jejunu.usermenagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    //html을 띄우기 위한 과정(@Override addViewControllers)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/list");
        registry.addViewController("/create").setViewName("edit"); //edit.html 사용
    }
}
