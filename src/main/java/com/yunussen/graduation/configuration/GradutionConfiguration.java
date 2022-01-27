package com.yunussen.graduation.configuration;

import com.yunussen.graduation.configuration.contains.GraduationContains;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {GraduationContains.BASE_PACKAGE})
public class GradutionConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
