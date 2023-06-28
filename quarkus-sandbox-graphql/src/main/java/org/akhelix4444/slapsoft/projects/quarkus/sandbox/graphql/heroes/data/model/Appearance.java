package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appearance {

    private String gender;

    private String race;

    private List<String> height = new ArrayList<>();

    private List<String> weight = new ArrayList<>();

    private String eyeColor;

    private String hairColor;

}
