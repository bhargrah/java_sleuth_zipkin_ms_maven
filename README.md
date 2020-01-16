# Managing latency in microservices with Sleuth Zipkin 

## Microservices Function
| Name  | URL | IsSleuth Enabled |
| ------------- | ------------- | ------------- |
| Booking Service  | http://localhost:9351/  | Y |
| Treasury Service  | http://localhost:9352/  | Y |
| Exchange Service  | http://localhost:9353/ | Y |
| Document Service  | http://localhost:9354/  | Y |
| Third Party Service  | http://localhost:9355/  | N |
| Zipkin Service | http://localhost:9092/ | NA |

## Depedencies among microservices 
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/Interaction.png)

## Sleuth Integration 
#### pom.xml
``` xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
#### application.properties
``` java
spring.sleuth.enabled=true
spring.sleuth.sampler.probability=1.0

spring.zipkin.base-url=http://localhost:9092/
```
#### zipkin server (pom.xml)
``` xml
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-server</artifactId>
    <version>2.8.0</version>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
    <version>2.8.0</version>
</dependency>
```
## Zipkin Stats
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/spans_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/trace_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/booking_flow.png)

#### Scenario-1 : Plain vanilla when all service works
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/vanilla.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/vanilla_zipkin.png)
#### Scenario-2 : Exception occured in one service 
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/exeption.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/exception_zipkin.png)

#### Scenario-3 : No sleuth integration in few services
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/third.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/third_zipkin.png)



