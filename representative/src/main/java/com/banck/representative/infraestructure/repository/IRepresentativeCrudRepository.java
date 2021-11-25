package com.banck.representative.infraestructure.repository;

import com.banck.representative.infraestructure.model.dao.RepresentativeDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface IRepresentativeCrudRepository extends ReactiveCrudRepository<RepresentativeDao, String> {
    Flux<RepresentativeDao> findAllByAccount(String account);

    Flux<RepresentativeDao> findAllByCustomer(String customer);

    Flux<RepresentativeDao> findAllByCustomerAndAccount(String customer, String account);
}
