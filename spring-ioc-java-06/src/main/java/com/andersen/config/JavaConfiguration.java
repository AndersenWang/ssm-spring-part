package com.andersen.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan(value = {"com.andersen.ioc_01"})
@PropertySource(value = "classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

    @Value("${andersen.url}")
    private String url;

    @Value("${andersen.driver}")
    private String driver;

    @Value("${andersen.username}")
    private String username;

    @Value("${andersen.password}")
    private String password;

    /**
     * 问题1：beanName的问题
     *      默认：方法名
     *      指定：name/value属性起名字，覆盖方法名
     * 问题2：周期方法如何指定
     *      使用原有注解： PostConstruct / PreDestroy 注解指定
     *      bean属性指定： initMethod / destroyMethod 指定
     * 问题3：作用域
     *      @Scope 注解，默认是单例
     * 问题4：如何引用其他ioc组件
     *      其他组件也是@bean方法，直接调用
     *      在形参列表声明想要的组件类型，一个或多个，ioc自动注入
     */

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "dataSource", initMethod = "", destroyMethod = "")
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSource1")
    public DruidDataSource druidDataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要dataSource
        // 1.其他组件也是@bean方法，直接调用
        jdbcTemplate.setDataSource(druidDataSource());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 需要dataSource
        // 2.在形参列表声明想要的组件类型，一个或多个，ioc自动注入
        // 如果ioc容器中找不到相应类型：报错
        // 如果找到多个：可以使形参名称等于对应的beanid标识即可
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}
