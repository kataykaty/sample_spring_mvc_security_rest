package com.sample.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sample.spring.app.controller.HomeController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=HomeController.class)
@ImportResource("classpath:spring-config.xml")
@Import(SecurityConfig.class)
public class ProjectConfig extends WebMvcConfigurerAdapter {
	
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/resource/view/", ".html");
		return viewResolver;
	}
	
	// set servlet is default handle
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	//setting resource css and js
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/resource/js/");
		registry.addResourceHandler("/theme-css/**").addResourceLocations("/resource/css/");
	}
}
