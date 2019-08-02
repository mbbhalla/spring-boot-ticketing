FROM adoptopenjdk/openjdk8:alpine-slim
COPY target/app.jar app.jar
EXPOSE 8080
CMD java  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar app.jar
