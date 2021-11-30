package com.banck.bankcustomer.aplication;

import com.banck.bankcustomer.domain.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CustomerOperations {

    public Flux<Customer> list();

    public Mono<Customer> get(String dniRuc);

    public Mono<Customer> create(Customer c);

    public Mono<Customer> update(String dniRuc, Customer c);

    public void delete(String dniRuc);

}
