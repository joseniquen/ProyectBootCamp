package com.banck.bankcustomer.aplication.model;

import com.banck.bankcustomer.domain.CustomerType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface CustomerTypeRepository {

    public Mono<CustomerType> get(String id);

    public Flux<CustomerType> listAll();

    public Mono<CustomerType> create(CustomerType c);

    public Mono<CustomerType> update(String id, CustomerType c);

    public void delete(String id);
}
