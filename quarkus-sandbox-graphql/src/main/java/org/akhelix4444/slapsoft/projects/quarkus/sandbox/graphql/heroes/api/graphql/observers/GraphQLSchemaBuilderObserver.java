package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.api.graphql.observers;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.smallrye.graphql.schema.model.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class GraphQLSchemaBuilderObserver {

    public GraphQLSchema.Builder beforeSchemaBuild(@Observes GraphQLSchema.Builder builder) {
        return builder;
    }

    public Operation createOperation(@Observes Operation operation) {
        log.info("Create GraphQL operation: " + operation.getName());

        return operation;
    }

    public GraphQL.Builder beforeGraphQLBuild(@Observes GraphQL.Builder builder) {
        return builder;
    }

}
