1. Run locally on native host

Start SERVER

````aidl
mvn clean package

java -Dgrpc.server.instances=1 -jar target/spring-grpc-demo-1.0.jar

````

Test if we can query server	

```aidl
To know service name
grpcurl --plaintext localhost:50051 list

then to know endpoint

grpcurl --plaintext localhost:50051 list helloworld.Greeter

then call it

grpcurl --plaintext -d '{"request":{"name":"a name","d":4.55332,"f":232.3,"b":true,"n":32,"l":444325235223,"c1":"ofcouse","pets":[{"name":"Bof the dog","color":"BLUE"}, {"name":"Kim the cat","color":"RED"}]}}' localhost:50051 helloworld.Greeter/SayHello

```

2. Run from a docker and hence we can benchmark it by ghz

From root folder of grpc_bench

```
./build.sh spring_boot_grpc

In other terminal: tail -f -n 5 spring_boot_grpc.tmp to check if there any error

If no error then can start benchmark code

./bench.sh spring_boot_grpc
