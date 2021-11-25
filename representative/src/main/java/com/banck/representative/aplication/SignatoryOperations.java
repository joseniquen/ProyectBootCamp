package com.banck.representative.aplication;

import com.banck.representative.domain.Signatory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SignatoryOperations {
    public Flux<Signatory> list();

    public Flux<Signatory> listByCustomer(String customer);

    public Flux<Signatory> listByAccount(String account);

    public Flux<Signatory> listByCustomerAndAccount(String customer, String account);

    public Mono<Signatory> get(String id);

    public Mono<Signatory> create(Signatory signatory);

    public Mono<Signatory> update(String id, Signatory signatory);

    public void delete(String id);
}
