FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE
ARG ENTRYPOINT_FILE
COPY ${JAR_FILE} app.jar
COPY ${ENTRYPOINT_FILE} entrypoint.sh
RUN ["chmod", "+x", "/entrypoint.sh"]
ENTRYPOINT ["/entrypoint.sh"]
