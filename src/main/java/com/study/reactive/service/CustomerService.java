package com.study.reactive.service;

import com.study.reactive.dao.CustomerDao;
import com.study.reactive.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customer> loadALlCustomers(){
        long start = System.currentTimeMillis();
        List<Customer> customerList = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Time taken for loadALlCustomers :: "+(end-start));
        return customerList;
    }

    public Flux<Customer> loadALlCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customerList = customerDao.getCustomersStream(50);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for loadALlCustomers :: "+(end-start));
        return customerList;
    }
}
