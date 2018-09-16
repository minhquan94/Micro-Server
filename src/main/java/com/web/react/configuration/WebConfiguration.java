/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.freemarker.FreeMarkerConfigurer;

/**
 * The Class WebConfiguration.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@EnableWebFlux
@Configuration
public class WebConfiguration implements WebFluxConfigurer {

  /**
   * {@inheritDoc}
   *
   * @see org.springframework.web.reactive.config.WebFluxConfigurer#addResourceHandlers(org.springframework.web.reactive.config.ResourceHandlerRegistry)
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  }

  /**
   * {@inheritDoc}
   *
   * @see org.springframework.web.reactive.config.WebFluxConfigurer#configureViewResolvers(org.springframework.web.reactive.config.ViewResolverRegistry)
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.freeMarker().suffix(".html");
  }

  /**
   * Static resource router.
   *
   * @return the router function
   */
  @Bean
  RouterFunction<ServerResponse> staticResourceRouter() {
    return RouterFunctions.resources("/**", new ClassPathResource("static/"));
  }

  /**
   * Free marker config.
   *
   * @return the free marker configurer
   */
  @Bean
  public FreeMarkerConfigurer freeMarkerConfig() {
    final FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
    freeMarkerConfigurer.setTemplateLoaderPath("classpath:/static/");
    return freeMarkerConfigurer;
  }

}
