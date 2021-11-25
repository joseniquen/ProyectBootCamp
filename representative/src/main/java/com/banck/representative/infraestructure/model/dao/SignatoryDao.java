package com.banck.representative.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("signatory")
public class SignatoryDao {
    @Id
    public String id;
    public String account;
    public String customer;
    public boolean status;
}
