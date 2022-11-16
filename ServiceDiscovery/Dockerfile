FROM openjdk:11-jre-slim as builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} servicediscovery.jar
RUN java -Djarmode=layertools -jar servicediscovery.jar extract

FROM openjdk:11-jre-slim
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
EXPOSE 8761