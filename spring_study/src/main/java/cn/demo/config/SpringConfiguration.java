package cn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


//引入其他配置文件，模块开发
@Import({
        DataSourceConfiguration.class,
        JdbcTemplateConfiguration.class,
})
//使用aspectj自动代理AOP
@EnableAspectJAutoProxy
//如果事务控制需要和 与环绕绕通知 一起使用的话，order要比他们大！ order越小优先级越高
@EnableTransactionManagement
@PropertySource("classpath:aspectOrder.properties")
//设置扫描注解的包, 排除controller包
@ComponentScan(
        basePackages = "cn.demo",
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = "cn.demo.controller.*"
                )
        }
)
@Configuration                              //设置为加载注解的类
public class SpringConfiguration {

    @Bean
    @Autowired
    public PlatformTransactionManager txManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
