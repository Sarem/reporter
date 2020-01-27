package com.aio.aionet.reporter.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//TODO add multi schema

//@Configuration
public class PrimaryDataSourceConfig {

//    @Bean
//    @Primary
//    @ConfigurationProperties("app.datasource")
//    public DataSourceProperties memberDataSourceProperties() {
//        return new DataSourceProperties();
//    }

//    @Bean
//    @Primary
//    @ConfigurationProperties("app.datasource.member.configuration")
//    public DataSource memberDataSource() {
//        return memberDataSourceProperties().initializeDataSourceBuilder()
//                .type(HikariDataSource.class).build();
//
//
//    }
}
