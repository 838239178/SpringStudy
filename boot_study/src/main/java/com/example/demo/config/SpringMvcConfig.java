package com.example.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.utils.MapBuilder;
import com.example.demo.utils.cl;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    private FastJsonHttpMessageConverter fastjson() {
        FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
        fjc.setSupportedMediaTypes(cl.list(MediaType.APPLICATION_JSON));
        fjc.setFastJsonConfig(new FastJsonConfig() {{
            setDateFormat("yyyy-mm-dd");
            setCharset(StandardCharsets.UTF_8);
            setSerializerFeatures(
                    SerializerFeature.DisableCircularReferenceDetect,
                    SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty
            );
        }});
        return fjc;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastjson());
    }
}
