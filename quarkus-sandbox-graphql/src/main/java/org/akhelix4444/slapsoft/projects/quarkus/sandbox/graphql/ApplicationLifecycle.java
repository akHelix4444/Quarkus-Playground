package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ApplicationLifecycle {

    public void onStart(@Observes StartupEvent startupEvent) {
        log.info("Quarkus Sandbox GraphQL application is starting...");
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        log.info("Quarkus Sandbox GraphQL application is stopping...");
    }

}
