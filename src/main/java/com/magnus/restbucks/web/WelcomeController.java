package com.magnus.restbucks.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.builder.EntityBuilder;
import com.google.code.siren4j.component.builder.LinkBuilder;

@RestController
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public ResponseEntity<Entity> returnRoot() {
    Link selfLink =
        LinkBuilder.newInstance().setRelationship(Link.RELATIONSHIP_SELF).setHref("/").build();

    Link nextLink =
        LinkBuilder.newInstance().setRelationship(Link.RELATIONSHIP_NEXT).setHref("/1").build();

    List<Link> links = new ArrayList<Link>();
    links.add(selfLink);
    links.add(nextLink);

    Entity result = EntityBuilder.newInstance().addLinks(links).build();

    return new ResponseEntity<Entity>(result, HttpStatus.OK);
  }
  
}
