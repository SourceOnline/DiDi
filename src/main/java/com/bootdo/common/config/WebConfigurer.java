package com.bootdo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bootdo.common.aspect.ApiTokenInterceptor;

@Component
class WebConfigurer extends WebMvcConfigurerAdapter {
	@Autowired
	BootdoConfig bootdoConfig;
	@Autowired
	private ApiTokenInterceptor apiTokenInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("file:///"+bootdoConfig.getUploadPath());
	}

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(apiTokenInterceptor).addPathPatterns("/api/user/**");
         registry.addInterceptor(apiTokenInterceptor).addPathPatterns("/api/subject/**");
         registry.addInterceptor(apiTokenInterceptor).addPathPatterns("/api/order/**");
         registry.addInterceptor(apiTokenInterceptor).addPathPatterns("/api/test/**");
    }
}