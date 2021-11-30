package com.banck.bankcustomer.infraestructure.rest;

import com.banck.bankcustomer.aplication.CustomerTypeOperations;
import com.banck.bankcustomer.domain.CustomerType;
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
@RequestMapping("/customerType")
@RequiredArgsConstructor
public class CustomerTypeController {

    private final CustomerTypeOperations operations;

    @GetMapping
    public Flux<CustomerType> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<CustomerType> get(@PathVariable("id") String id) {
        return operations.get(id);
    }

    @PostMapping
    public Mono<CustomerType> create(@RequestBody CustomerType c) {
        return operations.create(c);
    }

    @PutMapping("/{id}")
    public Mono<CustomerType> update(@PathVariable("id") String id, @RequestBody CustomerType c) {
        return operations.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }
}
