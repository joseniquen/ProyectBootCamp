package com.banck.bankcustomer.infraestructure.rest;

import com.banck.bankcustomer.aplication.CustomerOperations;
import com.banck.bankcustomer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerOperations operations;

    @GetMapping
    public Flux<Customer> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Customer> get(@PathVariable("id") String dniRuc) {
        return operations.get(dniRuc);
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer c) {
        return operations.create(c);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable("id") String dniRuc, @RequestBody Customer c) {
        return operations.update(dniRuc, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String dniRuc) {
        operations.delete(dniRuc);
    }
}
