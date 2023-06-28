package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository;

import java.util.List;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.AttributesInfo;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.Hero;

public interface IHeroRepository {

    List<Hero> getHeroes();

    Hero getHeroById(String heroId);

    AttributesInfo getAttributesByHeroId(String heroId);

    List<AttributesInfo> getAttributesByHeroIdBatch(List<String> heroIds);

}
