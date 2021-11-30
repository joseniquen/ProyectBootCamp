package com.banck.bankcustomer.infraestructure.mockRepository;

import com.banck.bankcustomer.aplication.model.CustomerRepository;
import com.banck.bankcustomer.domain.Customer;
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
public class MockCustomerRepository implements CustomerRepository {

    @Override
    public Mono<Customer> getCustomer(String dniRuc) {
        Customer c = new Customer();
        c.setDniRuc("34984545");
        c.setCustomerType("CTP");
        c.setNombreRS("Empresa sac.");
        c.setDireccion("Jr. Andy LT. 18  ZN. 2 Trujillo");
        return Mono.just(c);
    }

    @Override
    public Flux<Customer> listAllCustomer() {
        List<Customer> lc = new ArrayList<>();
        Customer c = new Customer();
        c.setDniRuc("34984545");
        c.setCustomerType("CTP");
        c.setNombreRS("Empresa sac.");
        c.setDireccion("Jr. Andy LT. 18  ZN. 2 Trujillo");
        lc.add(c);
        return Flux.fromIterable(lc);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        return Mono.just(c);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String dniRuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
