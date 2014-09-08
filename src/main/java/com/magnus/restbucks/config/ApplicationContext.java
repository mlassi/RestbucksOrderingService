package com.magnus.restbucks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.magnus.restbucks.assembler.WelcomeResourceAssembler;


@Configuration
@ComponentScan(basePackages = {"com.magnus.restbucks"})
@PropertySource("classpath:application.properties")
public class ApplicationContext {

  @Bean
  public WelcomeResourceAssembler welcomeResourceAssembler() {
    return new WelcomeResourceAssembler();
  }
}
