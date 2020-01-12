# Managing latency in microservices with Sleuth Zipkin 

## Microservices Function
| Name  | URL | IsSleuth Enabled |
| ------------- | ------------- | ------------- |
| Booking Service  | http://localhost:9351/booking/newbooking  | Y |
| Treasury Service  | http://localhost:9352/treasury/checkfunds  | Y |
| Exchange Service  | http://localhost:9353/exchange/execute  | Y |
| Document Service  | http://localhost:9354/documentservice/upload  | Y |
| Third Party Service  | http://localhost:9355/thirdparty/process  | N |
| Zipkin Service | http://localhost:9092/ | NA |

## Depedencies among microservices 
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/Interaction.png)

## Sleuth Integration 

## Zipkin Stats

#### Scenario-1 : Plain vanilla when all service works
#### Scenario-2 : Exception occured in one service 
#### Scenario-3 : No sleuth integration in few services
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/spans_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/trace_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/booking_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/book_treas_flow.png)
