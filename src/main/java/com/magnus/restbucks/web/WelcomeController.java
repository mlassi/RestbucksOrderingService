package com.magnus.restbucks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.siren4j.component.Entity;
import com.magnus.restbucks.assembler.WelcomeResourceAssembler;

@RestController
public class WelcomeController {

  private WelcomeResourceAssembler assembler;

  @Autowired
  public WelcomeController(WelcomeResourceAssembler assembler) {
    this.assembler = assembler;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public ResponseEntity<Entity> returnRoot() {
    return new ResponseEntity<Entity>(this.assembler.toEntity(), HttpStatus.OK);
  }
  
}
