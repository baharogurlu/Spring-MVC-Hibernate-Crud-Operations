package com.metaformltd.ecosystem.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

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

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.metaformltd.ecosystem" })
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalStateException, PropertyVetoException, SQLException {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.metaformltd.ecosystem" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "datasource")
	public DataSource getDataSource() throws IllegalStateException, PropertyVetoException, SQLException {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
		dataSource.setUser(environment.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return dataSource;
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("spring.jpa.show-sql", "true");
		properties.put("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

}
