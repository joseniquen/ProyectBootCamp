package com.banck.representative.infraestructure.repository;

import com.banck.representative.aplication.model.RepresentativeRepository;
import com.banck.representative.domain.Representative;
import com.banck.representative.infraestructure.model.dao.RepresentativeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RepresentativeCrudRepository implements RepresentativeRepository {
    @Autowired
    IRepresentativeCrudRepository iRepresentativeCrudRepository;

    @Override
    public Mono<Representative> get(String id) {
        return iRepresentativeCrudRepository.findById(id).map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public Flux<Representative> list() {
        return iRepresentativeCrudRepository.findAll().map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public Mono<Representative> create(Representative representative) {
        //Flux<MovementDao> fmd = movementRepository.findAllByCustomer(movement.getCustomer());
        return iRepresentativeCrudRepository.save(RepresentativeToRepresentative(representative)).map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public Mono<Representative> update(String id, Representative c) {
        c.setId(id);
        return iRepresentativeCrudRepository.save(RepresentativeToRepresentative(c)).map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public void delete(String id) {
        iRepresentativeCrudRepository.deleteById(id).subscribe();
    }

    public Representative RepresentativeDaoToRepresentative(RepresentativeDao rd) {
        Representative r = new Representative();
        r.setId(rd.getId());
        r.setAccount(rd.getAccount());
        r.setCustomer(rd.getCustomer());
        r.setStatus(rd.isStatus());
        return r;
    }

    public RepresentativeDao RepresentativeToRepresentative(Representative r) {
        RepresentativeDao rd = new RepresentativeDao();
        rd.setId(r.getId());
        rd.setAccount(r.getAccount());
        rd.setCustomer(r.getCustomer());
        rd.setStatus(r.isStatus());
        return rd;
    }

    @Override
    public Flux<Representative> listByCustomer(String customer) {
        return iRepresentativeCrudRepository.findAllByCustomer(customer).map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public Flux<Representative> listByCustomerAndAccount(String customer, String account) {
        return iRepresentativeCrudRepository.findAllByCustomerAndAccount(customer, account).map(this::RepresentativeDaoToRepresentative);
    }

    @Override
    public Flux<Representative> listByAccount(String account) {
        return iRepresentativeCrudRepository.findAllByAccount(account).map(this::RepresentativeDaoToRepresentative);
    }
}
