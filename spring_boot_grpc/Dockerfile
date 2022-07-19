FROM openjdk:18.0.1

WORKDIR /app

COPY spring_boot_grpc /app
# COPY proto /app/src/main/proto

RUN /app/mvnw clean package

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS=""

ENTRYPOINT java -Dgrpc.server.instances="${GRPC_SERVER_CPUS:-1}" -jar /app/target/spring-grpc-demo-1.0.jar