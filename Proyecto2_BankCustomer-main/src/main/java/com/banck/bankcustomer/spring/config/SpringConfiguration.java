package com.banck.bankcustomer.spring.config;

import com.banck.bankcustomer.aplication.model.CustomerRepository;
import com.banck.bankcustomer.aplication.model.CustomerTypeRepository;
import com.banck.bankcustomer.infraestructure.repository.CustomerCrudRepository;
import com.banck.bankcustomer.infraestructure.repository.CustomerTypeCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public CustomerRepository repository() {
        return new CustomerCrudRepository();
    }

    @Bean
    public CustomerTypeRepository repositoryCustomerType() {
        return new CustomerTypeCrudRepository();
    }
}
