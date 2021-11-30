package com.banck.bankcustomer.aplication.impl;

import com.banck.bankcustomer.aplication.CustomerTypeOperations;
import com.banck.bankcustomer.aplication.model.CustomerTypeRepository;
import com.banck.bankcustomer.domain.CustomerType;
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
public class CustomerTypeOperationsImpl implements CustomerTypeOperations {

    private final CustomerTypeRepository repositoryCustomerType;

    @Override
    public Flux<CustomerType> list() {
        return repositoryCustomerType.listAll();
    }

    @Override
    public Mono<CustomerType> get(String dniRuc) {
        return repositoryCustomerType.get(dniRuc);
    }

    @Override
    public Mono<CustomerType> create(CustomerType c) {
        return repositoryCustomerType.create(c);
    }

    @Override
    public Mono<CustomerType> update(String dniRuc, CustomerType c) {
        return repositoryCustomerType.update(dniRuc, c);
    }

    @Override
    public void delete(String dniRuc) {
        repositoryCustomerType.delete(dniRuc);
    }

}
