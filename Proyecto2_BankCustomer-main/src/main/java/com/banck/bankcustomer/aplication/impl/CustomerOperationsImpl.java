package com.banck.bankcustomer.aplication.impl;

import com.banck.bankcustomer.aplication.CustomerOperations;
import com.banck.bankcustomer.aplication.model.CustomerRepository;
import com.banck.bankcustomer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class CustomerOperationsImpl implements CustomerOperations {

    private final CustomerRepository repository;

    @Override
    public Flux<Customer> list() {
        return repository.listAllCustomer();
    }

    @Override
    public Mono<Customer> get(String dniRuc) {
        return repository.getCustomer(dniRuc);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        return repository.create(c);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        return repository.update(dniRuc, c);
    }

    @Override
    public void delete(String dniRuc) {
        repository.delete(dniRuc);
    }

}
