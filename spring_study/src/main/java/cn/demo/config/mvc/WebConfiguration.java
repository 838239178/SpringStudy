package cn.demo.config.mvc;

import cn.demo.config.SpringConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.nio.charset.StandardCharsets;

public class WebConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定 ContextLoaderListener 所需的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    /**
     * 指定mvc的核心配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfiguration.class};
    }

    /**
     * 等同于设置 DispatcherServlet 的 url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器<br/>
     *
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8"),
        };
    }

}
