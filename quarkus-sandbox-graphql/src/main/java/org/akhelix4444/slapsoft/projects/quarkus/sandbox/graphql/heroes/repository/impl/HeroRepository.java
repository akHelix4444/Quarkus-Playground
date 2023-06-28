package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.AttributesInfo;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.Hero;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.IHeroRepository;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.IInMemoryRepository;

@ApplicationScoped
public class HeroRepository
        implements IHeroRepository {

    @Inject
    IInMemoryRepository memoryRepository;

    @Override
    public List<Hero> getHeroes() {
        return memoryRepository.getHeroes();
    }

    @Override
    public Hero getHeroById(String heroId) {
        return getHeroes().stream()
                .filter(hero -> hero.getId().equals(heroId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public AttributesInfo getAttributesByHeroId(String heroId) {
        return getHeroById(heroId).getPowerstats();
    }

    @Override
    public List<AttributesInfo> getAttributesByHeroIdBatch(List<String> heroIds) {
        return getHeroes().stream()
                .filter(hero -> heroIds.contains(hero.getId()))
                .map(hero -> hero.getPowerstats())
                .collect(Collectors.toList());
    }

}
