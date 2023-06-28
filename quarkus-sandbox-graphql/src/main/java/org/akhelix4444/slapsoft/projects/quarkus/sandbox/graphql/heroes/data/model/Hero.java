package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hero {

    private String id;

    private String name;

    private String slug;

    private AttributesInfo powerstats;

    private Appearance appearance;

    private Biography biography;

    private Work work;

    private Communication connections;

    private Poster images;

}
