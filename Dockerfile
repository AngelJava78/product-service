FROM openjdk:21-jdk

RUN groupadd -g 999 appuser && \
    useradd -r -u 999 -g appuser appuser

COPY target/product-service.jar app.jar

USER appuser

ENTRYPOINT ["java", "-jar", "/app.jar"]

#ENTRYPOINT ["java", "-jar", "-Dspring.config.location=/etc/config/application.yml", "/app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]

EXPOSE 8080
