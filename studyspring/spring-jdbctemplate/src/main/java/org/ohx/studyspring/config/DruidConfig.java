package org.ohx.studyspring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 使用{@link PropertySource}加载.properties文件，这个注解要放在能被{@link ComponentScan}扫描到的类上，
 * 也可以写一个空类加上专门用{@link PropertySource}注解所有的.properties文件。
 * 使用{@link Value}注解从.properties文件中获取参数
 *
 * @author mudkip
 * @date 2022/7/20
 */
@Component
@PropertySource({"classpath:jdbc.properties"})
public class DruidConfig {
    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    /**
     * 返回一个数据库连接池对象作为Bean。
     * <p>
     * {@link Bean}注解是把方法返回的对象注册到容器中成为Bean
     *
     * @return 数据库连接池对象
     */
    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return druidDataSource;
    }
}
