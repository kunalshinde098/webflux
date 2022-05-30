package com.study.reactive.controller;


import com.study.reactive.dto.Customer;
import com.study.reactive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    CustomerService service;

    @RequestMapping("all")
    public List<Customer> getAllCutomers(){
        return service.loadALlCustomers();
    }

    @RequestMapping(value = "/all/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCutomersStream(){
        return service.loadALlCustomersStream();
    }
}
