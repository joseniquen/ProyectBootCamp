package com.banck.representative.infraestructure.rest;

import com.banck.representative.aplication.RepresentativeOperations;
import com.banck.representative.aplication.SignatoryOperations;
import com.banck.representative.domain.Representative;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/representative")
@RequiredArgsConstructor
public class ControllerRepresentative {
    private final RepresentativeOperations representativeOperations;

    //Represenative
    @GetMapping
    public Flux<Representative> listAll() {
        return representativeOperations.list();
    }

    @GetMapping("/{id}")
    public Mono<Representative> get(@PathVariable("id") String id) {
        return representativeOperations.get(id);
    }

    @GetMapping("/customer/{id}/list")
    public Flux<Representative> listByCustomer(@PathVariable("id") String id) {
        return representativeOperations.listByCustomer(id);
    }

    @GetMapping("/account/{id}/list")
    public Flux<Representative> listByAccount(@PathVariable("id") String id) {
        return representativeOperations.listByAccount(id);
    }

    @GetMapping("/customer-account/{customer}/{account}/list")
    public Flux<Representative> listByCustomerAndAccount(@PathVariable("customer") String customer, @PathVariable("account") String account) {
        return representativeOperations.listByCustomerAndAccount(customer, account);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Representative c) {
        c.setId(c.getCustomer() + "-" + getRandomNumberString());
        c.setStatus(true);
        return  representativeOperations.create(c).flatMap(i -> {
                        return Mono.just(ResponseEntity.ok(i));
                    });
    }

    @PutMapping("/{id}")
    public Mono<Representative> update(@PathVariable("id") String id, @RequestBody Representative representative) {
        return representativeOperations.update(id, representative);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        representativeOperations.delete(id);
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

}
