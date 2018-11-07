package com.demo.web.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SwaggerController {

  public SwaggerController() {

  }

  @RequestMapping({"/"})
  public ModelAndView home() {
    return new ModelAndView("redirect:/swagger-ui.html");
  }

}
