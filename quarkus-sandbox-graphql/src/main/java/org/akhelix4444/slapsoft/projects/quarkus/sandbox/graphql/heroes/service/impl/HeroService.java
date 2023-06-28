package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.HeroType;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.dto.type.StatsInfoType;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.AttributesInfo;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.Hero;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.IHeroRepository;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.service.IHeroService;

@ApplicationScoped
public class HeroService
        implements IHeroService {

    @Inject
    IHeroRepository heroRepository;

    @Override
    public List<HeroType> getHeroes() {
        return heroRepository.getHeroes().stream()
                .map(this::convertHero2Type)
                .collect(Collectors.toList());
    }

    @Override
    public HeroType getHeroById(String heroId) {
        return convertHero2Type(heroRepository.getHeroById(heroId));
    }

    @Override
    public List<StatsInfoType> getStatsInfoByHeroIdBatch(List<String> heroIds) {
        return heroRepository.getAttributesByHeroIdBatch(heroIds).stream()
                .map(this::convertAttributesInfo2Type)
                .collect(Collectors.toList());
    }

    private HeroType convertHero2Type(Hero hero) {
        return HeroType.create(hero.getId(), hero.getName(), hero.getSlug());
    }

    private StatsInfoType convertAttributesInfo2Type(AttributesInfo attributesInfo) {
        return new StatsInfoType()
                .intelligence(attributesInfo.getIntelligence())
                .strength(attributesInfo.getStrength())
                .speed(attributesInfo.getSpeed())
                .durability(attributesInfo.getDurability())
                .power(attributesInfo.getPower())
                .combat(attributesInfo.getCombat());
    }

}
