package com.sample.spring.servlet.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.sample.spring.config.ProjectConfig;

public class ProjectServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ProjectConfig.class);
		
		ServletRegistration.Dynamic dynamicServlet = container.addServlet("sample", new DispatcherServlet(context));
		dynamicServlet.setLoadOnStartup(1);
		dynamicServlet.addMapping("/");
	}

}
