package com.github.gazizovrim.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by vladislav on 28.04.2015.
 */
@Configuration
public class DataSourceConfig {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/livejournal";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "12345";
    private static final String DRIVER   = "org.postgresql.Driver";

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(DRIVER);
        dataSource.setJdbcUrl(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

}
