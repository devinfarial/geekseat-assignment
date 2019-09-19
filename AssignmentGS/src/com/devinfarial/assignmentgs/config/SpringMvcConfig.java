package com.devinfarial.assignmentgs.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.devinfarial.assignmentgs.dao.UserDAO;
import com.devinfarial.assignmentgs.dao.UserDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.devinfarial.assignmentgs")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/geekseat");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	//SpringMVC mapping
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImpl(getDataSource());
	}
}
