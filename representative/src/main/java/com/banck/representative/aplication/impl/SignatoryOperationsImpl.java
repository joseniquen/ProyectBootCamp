package com.banck.representative.aplication.impl;

import com.banck.representative.aplication.SignatoryOperations;
import com.banck.representative.aplication.model.SignatoryRepository;
import com.banck.representative.domain.Signatory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SignatoryOperationsImpl implements SignatoryOperations {
    private final SignatoryRepository signatoryRepository;

    @Override
    public Flux<Signatory> list() {
        return signatoryRepository.list();
    }

    @Override
    public Mono<Signatory> get(String id) {
        return signatoryRepository.get(id);
    }

    @Override
    public Mono<Signatory> create(Signatory signatory) {
        return signatoryRepository.create(signatory);
    }

    @Override
    public Mono<Signatory> update(String id, Signatory c) {
        return signatoryRepository.update(id, c);
    }

    @Override
    public void delete(String id) {
        signatoryRepository.delete(id);
    }

    @Override
    public Flux<Signatory> listByCustomer(String customer) {
        return signatoryRepository.listByCustomer(customer);
    }

    @Override
    public Flux<Signatory> listByCustomerAndAccount(String customer, String account) {
        return signatoryRepository.listByCustomerAndAccount(customer, account);
    }

    @Override
    public Flux<Signatory> listByAccount(String account) {
        return signatoryRepository.listByAccount(account);
    }

}
