package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroType {

    private String id;

    private String name;

    private String slug;

    public static HeroType create(String id, String name, String slug) {
        var hero = new HeroType();
        hero.setId(id);
        hero.setName(name);
        hero.setSlug(slug);

        return hero;
    }

}
