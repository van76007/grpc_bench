1. This repo benchmark Spring Boot Grpc repo: https://github.com/yidongnan/grpc-spring-boot-starter
Other flavour of Spring Boot Grpc is LogNet: https://github.com/LogNet/grpc-spring-boot-starter
That repo has more Netty settings. Feel free to modify pom.xml to test, e.g.:

```aidl
<dependency>
  <groupId>io.github.lognet</groupId>
  <artifactId>grpc-spring-boot-starter</artifactId>
  <version>4.5.5</version>
</dependency>
```

2. Run locally on native host

Start SERVER

````aidl
mvn clean package
java -Dgrpc.server.instances=1 -jar target/spring-grpc-demo-1.0.jar
````

Test if we can query server	

```aidl
To know service name
grpcurl --plaintext localhost:50051 list

To know endpoint
grpcurl --plaintext localhost:50051 list helloworld.Greeter

To call it
grpcurl --plaintext -d '{"request":{"name":"a name","d":4.55332,"f":232.3,"b":true,"n":32,"l":444325235223,"c1":"ofcouse","pets":[{"name":"Bof the dog","color":"BLUE"}, {"name":"Kim the cat","color":"RED"}]}}' localhost:50051 helloworld.Greeter/SayHello
```

3. Run from a docker to benchmark

```
From root folder of grpc_bench
./build.sh spring_boot_grpc

In other terminal, run this command to check if there any error
tail -f -n 5 spring_boot_grpc.tmp

If no error then can start benchmark code
./bench.sh spring_boot_grpc
```