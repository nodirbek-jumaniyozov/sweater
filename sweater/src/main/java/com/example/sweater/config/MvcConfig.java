package com.example.sweater.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/assets/js/",
                "/assets/js/vendor/",
                "/assets/css/",
                "/assets/flag-icon-master/",
                "/assets/images/",
                "/assets/fonts/"
        ).addResourceLocations(
                "classpath:/static/assets/js/",
                "classpath:/static/assets/js/vendor/",
                "classpath:/static/assets/css/",
                "classpath:/static/assets/flag-icon-master/",
                "classpath:/static/assets/images/",
                "classpath:/static/assets/fonts/"
        );
    }
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }

//    @Bean
//    public LocaleResolver localeResolver() {
//        Locale _ru = new Locale("en");
//        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(_ru);
//        return resolver;
//    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor() {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        return localeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
    }

}
