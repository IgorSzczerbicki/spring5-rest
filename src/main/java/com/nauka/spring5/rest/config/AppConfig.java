package com.nauka.spring5.rest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.nauka.spring5.rest")
@PropertySource("classpath:jdbc.properties")
public class AppConfig implements WebMvcConfigurer {
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private Environment env;
	
	@Bean 
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setPrefix("/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		//utworzenie connection pool
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		
		//ustawienie parametrów JDBC
		try {
			comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			exc.printStackTrace();
		}
		
		comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
		
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		comboPooledDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		comboPooledDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		comboPooledDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return comboPooledDataSource;
	}
	
	//funkcja pomocnicza
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
	}
	
	//factorySession
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		localSessionFactoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		localSessionFactoryBean.setDataSource(dataSource());
		return localSessionFactoryBean;
	}
	
	//hibernate transaction manager
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory localSessionFactoryBean) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(localSessionFactoryBean);
		return transactionManager;
	}
	
	//ustawienie zasobow
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
}