package com.banck.representative.infraestructure.repository;

import com.banck.representative.infraestructure.model.dao.SignatoryDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ISignatoryCrudRepository extends ReactiveCrudRepository<SignatoryDao, String> {
    Flux<SignatoryDao> findAllByAccount(String account);

    Flux<SignatoryDao> findAllByCustomer(String customer);

    Flux<SignatoryDao> findAllByCustomerAndAccount(String customer, String account);
}
