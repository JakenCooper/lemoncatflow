package com.jaken.lemoncatflow.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.jaken.lemoncatflow.service")
public class RootConfig {

}
