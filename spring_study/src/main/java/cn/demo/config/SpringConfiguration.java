package cn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;



//引入其他配置文件，模块开发
@Import({
        DataSourceConfiguration.class,
        JdbcTemplateConfiguration.class,
})
@EnableAspectJAutoProxy                     //使用aspectj自动代理AOP
//如果事务控制需要和 与环绕绕通知 一起使用的话，order要比他们大！ order越小优先级越高
@EnableTransactionManagement
@PropertySource("classpath:aspectOrder.properties")
@ComponentScan("cn.demo")                       //设置扫描注解的包
@Configuration                              //设置为加载注解的类
public class SpringConfiguration {

    @Bean
    @Autowired
    public PlatformTransactionManager txManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
