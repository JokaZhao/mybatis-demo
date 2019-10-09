package com.joka.sharding.mybatis.config;

import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.jdbc.core.datasource.ShardingDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/10/8 20:04.
 *
 * @author zhaozengjie
 * Description :
 */
@Configuration
@MapperScan("com.joka.sharding.mybatis.dao")
public class DataSourceConfiguration {

    @Bean(name = "shardingDataSource")
    public DataSource getDataSources() throws SQLException {

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();

        shardingRuleConfiguration.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        shardingRuleConfiguration.getBindingTableGroups().add("user");
        shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(
                new StandardShardingStrategyConfiguration("user_no",DemoDatabaseShardingAlgorithm.class.getName()));
        shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(
                new StandardShardingStrategyConfiguration("user_no",DemoTableShardingAlgorithm.class.getName()));
        return new ShardingDataSource(shardingRuleConfiguration.build(createDataSourceMap()));
    }

    @Bean
    public TableRuleConfiguration getUserTableRuleConfiguration(){
        TableRuleConfiguration configuration = new TableRuleConfiguration();
        configuration.setLogicTable("user");
        configuration.setActualDataNodes("user_0.user_0${0..1},user_1.user_0${2..3}");
        return configuration;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource shardingDataSource){
        return new DataSourceTransactionManager(shardingDataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    private Map<String,DataSource> createDataSourceMap(){
        Map<String,DataSource> result = new HashMap<>();
        result.put("user_0",createDataSource("user_0"));
        result.put("user_1",createDataSource("user_1"));
        return result;
    }

    private DataSource createDataSource(String dataSourceName){
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName("com.mysql.cj.jdbc.Driver");
        result.setUrl(String.format("jdbc:mysql://localhost:3306/%s?serverTimezone=UTC", dataSourceName));
        result.setUsername("zhaozengjie");
        result.setPassword("123456");
        return result;
    }

}
