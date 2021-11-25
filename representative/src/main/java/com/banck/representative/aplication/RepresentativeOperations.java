package com.banck.representative.aplication;

import com.banck.representative.domain.Representative;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepresentativeOperations {
    public Flux<Representative> list();

    public Flux<Representative> listByCustomer(String customer);

    public Flux<Representative> listByAccount(String account);

    public Flux<Representative> listByCustomerAndAccount(String customer, String account);

    public Mono<Representative> get(String id);

    public Mono<Representative> create(Representative representative);

    public Mono<Representative> update(String id, Representative representative);

    public void delete(String id);
}
