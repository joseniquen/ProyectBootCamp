package com.banck.bankcustomer.infraestructure.repository;

import com.banck.bankcustomer.infraestructure.model.dao.CustomerDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author jonavcar
 */
public interface ICustomerCrudRepository extends ReactiveCrudRepository<CustomerDao, String> {

}
