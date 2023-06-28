package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.api.graphql;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.HeroType;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.StatsInfoType;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.service.IHeroService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@GraphQLApi
public class HeroResource {

    @Inject
    IHeroService heroService;

    @Description("Return all heroes.")
    @Query("heroCollection")
    public List<HeroType> getHeroes() {
        log.info("Execute method: QUERY heroCollection");

        return heroService.getHeroes();
    }

    @Description("Return hero by id.")
    @Query
    public HeroType getHero(@Name("heroId") String heroId) {
        log.info("Execute method: QUERY hero");

        return heroService.getHeroById(heroId);
    }

    @Description("Return hero power stats info.")
    public List<StatsInfoType> statsInfo(@Source List<HeroType> heroes) {
        log.info("Execute method: QUERY Source statsInfo");

        var heroIds = heroes.stream()
                .map(HeroType::getId)
                .collect(Collectors.toList());

        return heroService.getStatsInfoByHeroIdBatch(heroIds);
    }

}
