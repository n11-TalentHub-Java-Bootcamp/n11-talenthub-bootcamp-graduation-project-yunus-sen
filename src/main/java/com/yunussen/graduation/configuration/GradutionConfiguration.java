package com.yunussen.graduation.configuration;

import com.yunussen.graduation.configuration.contains.GraduationContains;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {GraduationContains.BASE_PACKAGE})
public class GradutionConfiguration {
}
