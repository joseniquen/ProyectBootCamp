package com.banck.bankcustomer.infraestructure.repository;

import com.banck.bankcustomer.infraestructure.model.dao.CustomerTypeDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author jonavcar
 */
public interface ICustomerTypeCrudRepository extends ReactiveCrudRepository<CustomerTypeDao, String> {

}
