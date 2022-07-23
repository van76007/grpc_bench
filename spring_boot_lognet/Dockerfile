FROM openjdk:18.0.1

EXPOSE 5000

WORKDIR /app

COPY spring_boot_grpc /app
# COPY proto /app/src/main/proto

RUN /app/mvnw clean package

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS=""

ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \
 -Dcom.sun.management.jmxremote.authenticate=false \
 -Dcom.sun.management.jmxremote.port=5000 \
 -Dcom.sun.management.jmxremote.rmi.port=5000 \
 -Dcom.sun.management.jmxremote.host=0.0.0.0 \
 -Djava.rmi.server.hostname=0.0.0.0"

ENTRYPOINT java -Dgrpc.server.instances="${GRPC_SERVER_CPUS:-1}" -jar /app/target/spring-grpc-demo-1.0.jar