package cn.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration("cn.demo")//设置为加载注解的类，限定包名
@ComponentScan("cn.demo")//设置扫描注解的包
@EnableAspectJAutoProxy //使用aspectj自动代理AOP
@Import({DataSourceConfiguration.class, JdbcConfiguration.class})//引入其他配置文件，模块开发
public class SpringConfiguration {

}
