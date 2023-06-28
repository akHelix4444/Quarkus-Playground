package org.akhelix4444.slapsoft.projects.quarkus.sandbox.graphql;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@QuarkusMain
public class Main {

    public static void main(String... args) {
        log.info("Application IDE startup...");
        Quarkus.run(Application.class, args);
    }

    @Slf4j
    public static class Application
            implements QuarkusApplication {

        @Override
        public int run(String... args) {
            log.info("Execute application startup logic...");
            appPostInitLogic();

            log.info("Launch mode: " + LaunchMode.current().name());
            Quarkus.waitForExit();

            return 0;
        }

        private void appPostInitLogic() {
            log.info("Nothing to execute...");
        }

    }

}
