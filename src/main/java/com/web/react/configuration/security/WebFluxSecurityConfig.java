/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;

import com.web.react.configuration.security.jwt.JwtAuthenticationWebFilter;
import com.web.react.service.JwtTokenService;

/**
 * The Class WebFluxSecurityConfig.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebFluxSecurityConfig {

  /**
   * Securityg web filter chain.
   *
   * @param http
   *          the http
   * @param authenticationWebFilter
   *          the authentication web filter
   * @param entryPoint
   *          the entry point
   * @return the security web filter chain
   */
  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http,
      final JwtAuthenticationWebFilter authenticationWebFilter,
      final UnauthorizedAuthenticationEntryPoint entryPoint) {
    http.exceptionHandling().authenticationEntryPoint(entryPoint).and()
        .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
        .authorizeExchange().anyExchange().permitAll().and().formLogin().loginPage("/login")
        .and().csrf().disable();
    return http.build();
  }

  /**
   * Security context repository.
   *
   * @return the web session server security context repository
   */
  @Bean
  public WebSessionServerSecurityContextRepository securityContextRepository() {
    return new WebSessionServerSecurityContextRepository();
  }

  /**
   * Encoder.
   *
   * @return the password encoder
   */
  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Jwt token server.
   *
   * @return the jwt token server
   */
  @Bean
  public JwtTokenService jwtTokenServer() {
    return new JwtTokenService("admin", 100000L);
  }
}
