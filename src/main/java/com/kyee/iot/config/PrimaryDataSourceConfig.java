package com.kyee.iot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by wangl on 2017/3/9.
 */
@Configuration
@EnableTransactionManagement
public class PrimaryDataSourceConfig {

    @Bean(name = "bedServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource bedServerDataSource(){
        return DruidDataSourceBuilder.create()
                .build();
    }

    @Bean(name = "bedServerTranscationManager")
    @Primary
    public DataSourceTransactionManager bedServerTranscationManager(@Qualifier("bedServerDataSource") DataSource bedServerDataSource){
        return new DataSourceTransactionManager(bedServerDataSource);
    }

    @Bean(name = "bedServerSqlSessionFactory")
    @Primary
    public SqlSessionFactory bedServerSqlSessionFactory(@Qualifier("bedServerDataSource") DataSource bedServerDataSource)throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bedServerDataSource);
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
        //添加插件
//        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        return sessionFactory.getObject();
    }

    @Bean
    @Scope("prototype")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("bedServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer primaryScannerConfigurer(){
        MapperScannerConfigurer configur = new MapperScannerConfigurer();
        configur.setSqlSessionFactoryBeanName("bedServerSqlSessionFactory");
        //这个地方写的不好，要重新看
        configur.setBasePackage("com.kyee.iot.*.dao");
        return configur;
    }
}
