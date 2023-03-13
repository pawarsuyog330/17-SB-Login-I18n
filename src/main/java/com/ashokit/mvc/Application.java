package com.ashokit.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource msgSource = new ReloadableResourceBundleMessageSource();
		msgSource.setBasename("classpath:i18n");
		return msgSource;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChange()
	{
		LocaleChangeInterceptor intercept=new LocaleChangeInterceptor();
		intercept.setParamName("param");
		return intercept;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver()
	{
		return new SessionLocaleResolver();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(localeChange()).addPathPatterns("/**");
	}
}
