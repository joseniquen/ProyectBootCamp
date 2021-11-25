package com.banck.representative.infraestructure.repository;

import com.banck.representative.aplication.model.SignatoryRepository;
import com.banck.representative.domain.Representative;
import com.banck.representative.domain.Signatory;
import com.banck.representative.infraestructure.model.dao.RepresentativeDao;
import com.banck.representative.infraestructure.model.dao.SignatoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SignatoryCrudRepository implements SignatoryRepository {
    @Autowired
    ISignatoryCrudRepository iSignatoryCrudRepository;
    @Override
    public Mono<Signatory> get(String id) {
        return iSignatoryCrudRepository.findById(id).map(this::SignatoryDaoToSignatory);
    }

    @Override
    public Flux<Signatory> list() {
        return iSignatoryCrudRepository.findAll().map(this::SignatoryDaoToSignatory);
    }

    @Override
    public Mono<Signatory> create(Signatory signatory) {
        //Flux<MovementDao> fmd = movementRepository.findAllByCustomer(movement.getCustomer());
        return iSignatoryCrudRepository.save(SignatoryToSignatoryDao(signatory)).map(this::SignatoryDaoToSignatory);
    }

    @Override
    public Mono<Signatory> update(String id, Signatory c) {
        c.setId(id);
        return iSignatoryCrudRepository.save(SignatoryToSignatoryDao(c)).map(this::SignatoryDaoToSignatory);
    }

    @Override
    public void delete(String id) {
        iSignatoryCrudRepository.deleteById(id).subscribe();
    }

    public Signatory SignatoryDaoToSignatory(SignatoryDao rd) {
        Signatory r = new Signatory();
        r.setId(rd.getId());
        r.setAccount(rd.getAccount());
        r.setCustomer(rd.getCustomer());
        r.setStatus(rd.isStatus());
        return r;
    }

    public SignatoryDao SignatoryToSignatoryDao(Signatory r) {
        SignatoryDao rd = new SignatoryDao();
        rd.setId(r.getId());
        rd.setAccount(r.getAccount());
        rd.setCustomer(r.getCustomer());
        rd.setStatus(r.isStatus());
        return rd;
    }

    @Override
    public Flux<Signatory> listByCustomer(String customer) {
        return iSignatoryCrudRepository.findAllByCustomer(customer).map(this::SignatoryDaoToSignatory);
    }

    @Override
    public Flux<Signatory> listByCustomerAndAccount(String customer, String account) {
        return iSignatoryCrudRepository.findAllByCustomerAndAccount(customer, account).map(this::SignatoryDaoToSignatory);
    }

    @Override
    public Flux<Signatory> listByAccount(String account) {
        return iSignatoryCrudRepository.findAllByAccount(account).map(this::SignatoryDaoToSignatory);
    }
}
