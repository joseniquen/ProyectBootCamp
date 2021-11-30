package com.banck.bankcustomer.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("customer")
public class CustomerDao {

    @Id
    public String dniRuc;
    public String customerType;
    public String nombreRS;
    public String direccion;
}
