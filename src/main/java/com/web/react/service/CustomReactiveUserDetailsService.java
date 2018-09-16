/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.web.react.domain.CustomUserDetails;
import com.web.react.domain.entity.UserEntity;
import com.web.react.domain.repository.UserRepository;

import reactor.core.publisher.Mono;

/**
 * The Class CustomReactiveUserDetailsService.
 *
 * @author <a href="mailto:developer@hitachiconsulting.com">zuan_</a>
 */
@Service
public class CustomReactiveUserDetailsService implements ReactiveUserDetailsService {

  /** The user repository. */
  @Autowired
  public UserRepository userRepository;

  /**
   * {@inheritDoc}
   *
   * @see org.springframework.security.core.userdetails.ReactiveUserDetailsService#findByUsername(java.lang.String)
   */
  @Override
  public Mono<UserDetails> findByUsername(String username) {
    final UserEntity user = userRepository.findByUsername(username);
    return Mono.just(new CustomUserDetails(user));
  }
}
