package com.study.reactive.handler;

import com.study.reactive.dao.CustomerDao;
import com.study.reactive.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    CustomerDao customerDao;

    public Mono<ServerResponse> getCustomers(ServerRequest request){

        int range = Integer.parseInt(request.pathVariable("input"));
        Flux<Customer> customerFlux = customerDao.getCustomersStream(range);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerFlux,Customer.class);
    }
}
