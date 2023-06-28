package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository;

import java.util.List;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.Hero;

public interface IInMemoryRepository {

    List<Hero> getHeroes();

}
