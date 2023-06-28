package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql.heroes.api.graphql.eventing;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

import javax.json.bind.Jsonb;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.smallrye.graphql.api.Context;
import io.smallrye.graphql.execution.event.InvokeInfo;
import io.smallrye.graphql.schema.model.Operation;
import io.smallrye.graphql.spi.EventingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomGraphQLEventingService
        implements EventingService {

    private final Map<Context, Long> startTimes = Collections.synchronizedMap(new IdentityHashMap<>());

    @Override
    public String getConfigKey() {
        return null;
    }

    @Override
    public GraphQLSchema.Builder beforeSchemaBuild(GraphQLSchema.Builder builder) {
        return builder;
    }

    @Override
    public Operation createOperation(Operation operation) {
        return operation;
    }

    @Override
    public Map<String, Jsonb> overrideJsonbConfig() {
        return Collections.emptyMap();
    }

    @Override
    public GraphQL.Builder beforeGraphQLBuild(GraphQL.Builder builder) {
        return builder;
    }

    @Override
    public void beforeExecute(Context context) {
        var executionId = context.getExecutionId();
        var operation = context.getOperationName().orElse("UNKNOWN");
        log.info(executionId + " - Start execute request: " + operation);
    }

    @Override
    public void afterExecute(Context context) {
        var executionId = context.getExecutionId();
        var operation = context.getOperationName().orElse("UNKNOWN");
        log.info(executionId + " - Complete execute request: " + operation);
    }

    @Override
    public void errorExecute(Context context, Throwable t) {
        log.error("Error while operation execution: " + t.getMessage());
    }

    @Override
    public void beforeDataFetch(Context context) {
        // Before each result for each data fetches
        startTimes.put(context, System.nanoTime());
        log.info("== startTimes map size - " + startTimes.size() + " ==");
    }

    @Override
    public void beforeInvoke(InvokeInfo invokeInfo) throws Exception {
        var methodName = invokeInfo.getOperationMethod().getName();
        log.info("Execute method: " + methodName);
    }

    @Override
    public void afterDataFetch(Context context) {
        var executionId = context.getExecutionId();
        var dataFetchField = context.getFieldName();
        log.info(executionId + " - Complete fetch data: " + dataFetchField);

        var startTime = startTimes.remove(context);
        if (null != startTime) {
            var duration = System.nanoTime() - startTime;
            log.info("Operation execution time: " + duration);
        }
    }

    @Override
    public void errorDataFetch(Context context, Throwable t) {
        log.error("Error while data fetch: " + t.getMessage());
    }

}
