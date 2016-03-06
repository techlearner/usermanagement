package com.teleportcall.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by sriramk on 10/14/2014.
 */
@Configuration
public class SqlDatasourceConfig implements DataSourceConfig {

    @Value("${offer.jdbc.driver.class}")
    private String driverClass;

    @Value("${offer.jdbc.url}")
    private String jdbcUrl;

    @Value("${offer.jdbc.username}")
    private String username;

    @Value("${offer.jdbc.password}")
    private String password;
    
    @Value("${offer.jdbc.dbname}")
    private String dbName;

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource datasource = new ComboPooledDataSource();;
        try {
            datasource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        datasource.setJdbcUrl(jdbcUrl+"/"+dbName);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setMinPoolSize(5);
        datasource.setMaxIdleTime(2000);
        datasource.setMaxPoolSize(20);
        datasource.setMaxStatements(2000);
        return datasource;
    }

}
