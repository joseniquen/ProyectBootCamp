package com.banck.bankcustomer.infraestructure.mockRepository;

import com.banck.bankcustomer.aplication.model.CustomerTypeRepository;
import com.banck.bankcustomer.domain.CustomerType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Component
public class MockCustomerTypeRepository implements CustomerTypeRepository {

    @Override
    public Mono<CustomerType> get(String dniRuc) {
        CustomerType c = new CustomerType();
        c.setCodigo("34984545");
        c.setNombre("CTP");
        c.setDescripcion("Empresa sac.");
        return Mono.just(c);
    }

    @Override
    public Flux<CustomerType> listAll() {
        List<CustomerType> lc = new ArrayList<>();
        CustomerType c = new CustomerType();
        c.setCodigo("34984545");
        c.setNombre("CTP");
        c.setDescripcion("Empresa sac.");
        lc.add(c);
        return Flux.fromIterable(lc);
    }

    @Override
    public Mono<CustomerType> create(CustomerType c) {
        return Mono.just(c);
    }

    @Override
    public Mono<CustomerType> update(String dniRuc, CustomerType c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String dniRuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
