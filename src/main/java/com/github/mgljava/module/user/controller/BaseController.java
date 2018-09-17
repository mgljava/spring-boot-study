package com.github.mgljava.module.user.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {

  protected BaseController() {
    log.info("start BaseController!");
  }

  protected static final String SUCCESS = "success";
  protected static final String ERROR = "error";
}
