package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.impl;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbBuilder;

import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.data.model.Hero;
import org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.repository.IInMemoryRepository;

import io.quarkus.runtime.Startup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Startup
@ApplicationScoped
public class InMemoryRepository
        implements IInMemoryRepository {

    private static final String HEROES_FILE_PATH = "/Heroes.json";

    private List<Hero> heroes;

    @PostConstruct
    void readDataFromJson() {
        log.info("Try reading data from " + HEROES_FILE_PATH + " file...");

        var filePath = InMemoryRepository.class.getResource(HEROES_FILE_PATH).getPath();
        log.info("File path: " + filePath);

        var runtimeType = getRuntimeType();
        log.info("Runtime Type: " + runtimeType.getTypeName());

        heroes = doJsonFileReadingWithFileReader(filePath, runtimeType);
        log.info("File processing complete. Elements count - " + heroes.size());
    }

    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }

    private Type getRuntimeType() {
        return new ArrayList<Hero>() {

        }.getClass().getGenericSuperclass();
    }

    private List<Hero> doJsonFileReadingWithFileReader(String filePath, Type runtimeType) {
        List<Hero> heroes;

        try (var reader = new FileReader(filePath)) {
            var jsonb = JsonbBuilder.create();
            heroes = jsonb.fromJson(reader, runtimeType);
        } catch (IOException ex) {
            log.error("Error while reading data file.", ex);
            heroes = new ArrayList<>();
        }

        return heroes;
    }

}
