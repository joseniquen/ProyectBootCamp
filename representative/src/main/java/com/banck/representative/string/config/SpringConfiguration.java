package com.banck.representative.string.config;

import com.banck.representative.aplication.model.RepresentativeRepository;
import com.banck.representative.aplication.model.SignatoryRepository;
import com.banck.representative.infraestructure.repository.RepresentativeCrudRepository;
import com.banck.representative.infraestructure.repository.SignatoryCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public RepresentativeRepository representativeRepository() {
        return new RepresentativeCrudRepository();
    }
    @Bean
    public SignatoryRepository signatoryRepository() { return new SignatoryCrudRepository();    }

}
