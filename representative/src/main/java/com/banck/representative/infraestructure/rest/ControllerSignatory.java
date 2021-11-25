package com.banck.representative.infraestructure.rest;

import com.banck.representative.aplication.SignatoryOperations;
import com.banck.representative.domain.Representative;
import com.banck.representative.domain.Signatory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@RestController
@RequestMapping("/signatory")
@RequiredArgsConstructor
public class ControllerSignatory {
    private final SignatoryOperations signatoryOperations;
    //signatory
    @GetMapping
    public Flux<Signatory> listAll() {
        return signatoryOperations.list();
    }

    @GetMapping("/{id}")
    public Mono<Signatory> get(@PathVariable("id") String id) {
        return signatoryOperations.get(id);
    }

    @GetMapping("/customer/{id}/list")
    public Flux<Signatory> listByCustomer(@PathVariable("id") String id) {
        return signatoryOperations.listByCustomer(id);
    }

    @GetMapping("/account/{id}/list")
    public Flux<Signatory> listByAccount(@PathVariable("id") String id) {
        return signatoryOperations.listByAccount(id);
    }

    @GetMapping("/customer-account/{customer}/{account}/list")
    public Flux<Signatory> listByCustomerAndAccount(@PathVariable("customer") String customer, @PathVariable("account") String account) {
        return signatoryOperations.listByCustomerAndAccount(customer, account);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Signatory c) {
        c.setId(c.getCustomer() + "-" + getRandomNumberString());
        c.setStatus(true);
        return  signatoryOperations.create(c).flatMap(i -> {
            return Mono.just(ResponseEntity.ok(i));
        });
    }

    @PutMapping("/{id}")
    public Mono<Signatory> update(@PathVariable("id") String id, @RequestBody Signatory signatory) {
        return signatoryOperations.update(id, signatory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        signatoryOperations.delete(id);
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
