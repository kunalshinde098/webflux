package com.study.reactive.dao;

import com.study.reactive.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleep(int sleep){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> getCustomers(){
        return IntStream.range(1,50)
                .peek(CustomerDao::sleep)
                .peek(value -> System.out.println("Processing for "+value))
                .mapToObj(value -> new Customer(value, "Customer"+value))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream(int range){
        return Flux.range(1,range)
                .delayElements(Duration.ofMillis(10))
                .doOnNext(value -> System.out.println("Processing stream for "+value))
                .map(value -> new Customer(value, "Customer"+value))
                .log();
    }
}
