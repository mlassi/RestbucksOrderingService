package com.magnus.restbucks.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public ResponseEntity<String> returnRoot() {
    return new ResponseEntity<String>(HttpStatus.OK);
  }
  
}
