package cn.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ha.PropertiesUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@PropertySource("classpath:jdbc.properties")//加载配置文件
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driverName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.usr}")
    private String user;

    @Value("${jdbc.pwd}")
    private String password;

    @Bean("dataSource")
    public DataSource getDruid() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverName);
        ds.setUrl(jdbcUrl);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }
}
