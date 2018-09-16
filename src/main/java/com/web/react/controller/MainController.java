/*
 * Copyright (c) 2018 Zuan_Wiko
 */
package com.web.react.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Mono;

/**
 * The Class MainController.
 *
 * @author <a href="mailto:minhquan9402@gmail.com">zuan_</a>
 */
@Controller
public class MainController {

  /** The Constant INDEX. */
  private static final String INDEX = "index";

  /**
   * Index.
   *
   * @return the string
   */
  @GetMapping("")
  public Mono<String> index() {
    return Mono.just(INDEX);
  }

  /**
   * Login.
   *
   * @return the mono
   */
  @GetMapping(value = "/login")
  public Mono<String> login() {
    return Mono.just(INDEX);
  }
}
