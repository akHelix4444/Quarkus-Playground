package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Biography {

    private String fullName;

    private String alterEgos;

    private List<String> aliases = new ArrayList<>();

    private String placeOfBirth;

    private String firstAppearance;

    private String publisher;

    private String alignment;

}
