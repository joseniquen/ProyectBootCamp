package com.banck.bankcustomer.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jonavcar
 */
@Data
@Document("customerType")
public class CustomerTypeDao {

    @Id
    public String codigo;
    public String nombre;
    public String descripcion;
}
