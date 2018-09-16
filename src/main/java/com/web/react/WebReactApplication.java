/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.web.react.domain.repository.BaseJpaRepositoryImpl;

/**
 * The Class WebReactApplication.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@EnableJpaRepositories(basePackages = {
    "com.web.react.domain.repository" }, repositoryBaseClass = BaseJpaRepositoryImpl.class)
@EntityScan(basePackages = "com.web.react.domain.entity")
@SpringBootApplication
public class WebReactApplication {

  /**
   * The main method.
   *
   * @param args
   *          the arguments
   */
  public static void main(String[] args) {
    final SpringApplication application = new SpringApplication(WebReactApplication.class);
    application.setWebApplicationType(WebApplicationType.REACTIVE);
    application.run(args);
  }
}
