package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.service;

import java.util.List;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.HeroType;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.StatsInfoType;

public interface IHeroService {

    List<HeroType> getHeroes();

    HeroType getHeroById(String heroId);

    List<StatsInfoType> getStatsInfoByHeroIdBatch(List<String> heroIds);

}
