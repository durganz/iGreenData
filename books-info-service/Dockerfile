FROM maven:3.6.1-jdk-8-alpine as service-build
WORKDIR /deploy
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/deploy/target/dependency
COPY --from=service-build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=service-build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=service-build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.durganz.microservices.booksinfoservice.BooksInfoServiceApplication"]