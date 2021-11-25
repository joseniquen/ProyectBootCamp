package com.banck.representative.aplication.impl;

import com.banck.representative.aplication.RepresentativeOperations;
import com.banck.representative.aplication.model.RepresentativeRepository;
import com.banck.representative.domain.Representative;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RepresentativeOperationsImpl implements RepresentativeOperations {
    private final RepresentativeRepository representativeRepository;
    @Override
    public Flux<Representative> list() {
        return representativeRepository.list();
    }

    @Override
    public Mono<Representative> get(String id) {
        return representativeRepository.get(id);
    }

    @Override
    public Mono<Representative> create(Representative representative) {
        return representativeRepository.create(representative);
    }

    @Override
    public Mono<Representative> update(String id, Representative c) {
        return representativeRepository.update(id, c);
    }

    @Override
    public void delete(String id) {
        representativeRepository.delete(id);
    }

    @Override
    public Flux<Representative> listByCustomer(String customer) {
        return representativeRepository.listByCustomer(customer);
    }

    @Override
    public Flux<Representative> listByCustomerAndAccount(String customer, String account) {
        return representativeRepository.listByCustomerAndAccount(customer, account);
    }

    @Override
    public Flux<Representative> listByAccount(String account) {
        return representativeRepository.listByAccount(account);
    }


}
