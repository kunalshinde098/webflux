package com.study.reactive.handler;

import com.study.reactive.dao.CustomerDao;
import com.study.reactive.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CustomerHandler {

    @Autowired
    CustomerDao customerDao;

    public Mono<ServerResponse> getAllCustomers(ServerRequest request){
        Flux<Customer> customerFlux = customerDao.getCustomersStream(50);
        return ServerResponse.ok().body(customerFlux,Customer.class);

    }


}
