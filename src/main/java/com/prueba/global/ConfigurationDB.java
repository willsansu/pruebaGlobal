package com.prueba.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "EntityManajerFactory", transactionManagerRef = "TransactionManager",
basePackages = {"com.prueba.global.repository"})*/

public class ConfigurationDB {
	/*@Autowired
	private Environment env;
	
	@Bean(name = "DataSource")
	public DataSource DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		
		return dataSource;
	}
	
	@Primary
	@Bean(name = "EntityManajerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(DataSource());
		lcemfb.setPackagesToScan("com.prueba.global.entities");
		
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		lcemfb.setJpaVendorAdapter(hjva);
		
		Map<String, Object> mProperties = new HashMap<>();
		mProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
		mProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		mProperties.put("hibernate.default_schema", env.getProperty("spring.jpa.schema-default"));

		
		lcemfb.setJpaPropertyMap(mProperties);
		
		return lcemfb;
	}
	
	@Primary
	@Bean(name = "TransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return jtm;
	}*/
}
