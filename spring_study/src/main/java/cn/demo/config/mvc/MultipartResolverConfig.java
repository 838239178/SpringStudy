package cn.demo.config.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@PropertySource("classpath:multipartResolver.properties")
public class MultipartResolverConfig {

    @Value("${resolver.maxUploadSize}")
    private long mUpSize;

    @Value("${resolver.maxUploadSizePerFile}")
    private long mUpPerSize;

    @Value("${resolver.defaultEncoding}")
    private String encoding;

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(mUpSize);
        resolver.setMaxUploadSizePerFile(mUpPerSize);
        resolver.setDefaultEncoding(encoding);
        return resolver;
    }
}
