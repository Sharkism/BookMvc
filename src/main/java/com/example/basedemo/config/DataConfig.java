package com.example.basedemo.config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource(value="classpath:application.properties")
public class DataConfig {

    @Value("${datasource.driver}")
    private String jdbcDriverClassName;
    @Value("${datasource.url}")
    private String jdbcUrl;
    @Value("${datasource.username}")
    private String jdbcUserName;
    @Value("${datasource.password}")
    private String jdbcPassword;


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    /**
     * 用于产生SqlSessionFactory的工厂
     * @return
     * @throws IOException
     */
    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new
                PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfiguration(mybatisConfig());
        factoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:mybatis/mappers/*.xml"));
//        factoryBean.setTypeAliasesPackage("com.example.basedemo.pojo");
        return factoryBean;
    }

    /**
     * 替代mybatis配置文件的bean
     * @return
     */
    @Bean
    org.apache.ibatis.session.Configuration mybatisConfig() {
        org.apache.ibatis.session.Configuration config = new
                org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        return config;
    }
}
