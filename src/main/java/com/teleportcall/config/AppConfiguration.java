package com.teleportcall.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.dozer.DozerBeanMapper;
import org.hibernate.ConnectionReleaseMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by ssenthilkumar on 22/11/2015.
 */


@Configuration
@PropertySource("classpath:config.properties")
public class AppConfiguration {

	@Autowired
	private DataSourceConfig dataSourceConfiguration;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemb = new LocalContainerEntityManagerFactoryBean();
		lemb.setDataSource(dataSourceConfiguration.dataSource());
		lemb.setJpaVendorAdapter(jpaVendorAdapter());
		lemb.setJpaDialect(new HibernateJpaDialect());
		Properties prop = new Properties();
		prop.put(org.hibernate.cfg.Environment.RELEASE_CONNECTIONS, ConnectionReleaseMode.AFTER_TRANSACTION);
		lemb.setJpaProperties(prop);
		lemb.setPackagesToScan(new String[] { ("com.teleportcall.model") });
		return lemb;

	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
		Map<String, String> jpaProperties = new HashMap<>();
		jpaProperties.put("transactionTimeout", "43200");
		jpaTransactionManager.setJpaPropertyMap(jpaProperties);
		return jpaTransactionManager;
	}
	
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
	
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}

	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(false);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}		
}
