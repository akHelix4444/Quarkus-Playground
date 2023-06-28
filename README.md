# Quarkus Playground

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/> .

## Quarkus Sandbox Graphql

- Start project in `dev` mode from CLI:

```shell script
Unix: ./gradlew :quarkus-sandbox-graphql:quarkusDev

Windows: .\gradlew.bat :quarkus-sandbox-graphql:quarkusDev
```

- Start project from IDE: use `main` method in `Main` class.

- DEV UI: <http://localhost:8080/q/dev/>.

- Package application:

```shell script
Unix: ./gradlew :quarkus-sandbox-graphql:build

Windows: .\gradlew.bat :quarkus-sandbox-graphql:build
```

- Start app:

```shell script
Unix: java -jar ./quarkus-sandbox-graphql/build/quarkus-app/quarkus-run.jar

Windows: java -jar .\quarkus-sandbox-graphql\build\quarkus-app\quarkus-run.jar
```

- Generate _über-jar_:

```shell script
Unix: ./gradlew :quarkus-sandbox-graphql:build -Dquarkus.package.type=uber-jar

Windows: .\gradlew.bat :quarkus-sandbox-graphql:build "-Dquarkus.package.type=uber-jar"
```

- Start _über-jar_ app:

```shell script
Unix: java -jar ./quarkus-sandbox-graphql/build/*-runner.jar

Windows: java -jar .\quarkus-sandbox-graphql\build\<project>-<version>-runner.jar
```

- Create a native executable:

```shell script
Unix: ./gradlew :quarkus-sandbox-graphql:build -Dquarkus.package.type=native

Windows: .\gradlew.bat :quarkus-sandbox-graphql:build "-Dquarkus.package.type=native"
```

- Create a native executable with build in a container:

```shell script
Unix: ./gradlew :quarkus-sandbox-graphql:build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Windows: .\gradlew.bat :quarkus-sandbox-graphql:build "-Dquarkus.package.type=native" "-Dquarkus.native.container-build=true"
```
