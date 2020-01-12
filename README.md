# Managing latency in microservices with Sleuth Zipkin 

## Depedencies among microservices 
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/Interaction.png)

## Microservices Function
| Name  | URL | IsSleuth Enabled |
| ------------- | ------------- | ------------- |
| Booking Service  | http://localhost:9351/booking/newbooking  | Y |
| Treasury Service  | http://localhost:9352/treasury/checkfunds  | Y |
| Exchange Service  | http://localhost:9353/exchange/execute  | Y |
| Document Service  | http://localhost:9354/documentservice/upload  | Y |
| Third Party Service  | http://localhost:9354/documentservice/upload  | Y |
| Zipkin Service | http://localhost:9092/ | NA |


## Sleuth Integration 

## Zipkin Stats
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/spans_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/trace_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/booking_flow.png)
![](https://github.com/bhargrah/java_sleuth_zipkin_ms_maven/blob/master/images/book_treas_flow.png)
