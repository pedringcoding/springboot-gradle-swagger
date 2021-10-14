# temp container to build using gradle
FROM gradle:5.6.4-jdk8 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradle.properties config $APP_HOME/

RUN gradle build -x test || return 0
COPY . .
RUN gradle clean build -x test

# actual container
FROM adoptopenjdk/openjdk8:alpine-slim
ENV ARTIFACT_NAME=spring-boot-swagger-*.jar
ENV APP_HOME=/usr/app

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}