package com.banck.bankcustomer.aplication;

import com.banck.bankcustomer.domain.Customer;
import com.banck.bankcustomer.domain.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CustomerTypeOperations {

    public Flux<CustomerType> list();

    public Mono<CustomerType> get(String id);

    public Mono<CustomerType> create(CustomerType c);

    public Mono<CustomerType> update(String id, CustomerType c);

    public void delete(String id);

}
