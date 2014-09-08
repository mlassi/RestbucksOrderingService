package com.magnus.restbucks.test.builder;

import java.util.ArrayList;
import java.util.List;

import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.builder.EntityBuilder;
import com.google.code.siren4j.component.builder.LinkBuilder;

public class WelcomeAssemblerMother {

  public static Entity getRootLinksEntity() {
    Link selfLink =
        LinkBuilder.newInstance().setRelationship(Link.RELATIONSHIP_SELF).setHref("/").build();

    Link nextLink = LinkBuilder.newInstance().setRelationship("order").setHref("/order").build();

    List<Link> links = new ArrayList<Link>();
    links.add(selfLink);
    links.add(nextLink);

    Entity entity = EntityBuilder.newInstance().addLinks(links).build();

    return entity;
  }
}
