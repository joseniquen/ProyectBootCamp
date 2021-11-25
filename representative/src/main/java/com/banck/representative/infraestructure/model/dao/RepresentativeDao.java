package com.banck.representative.infraestructure.model.dao;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("representative")
public class RepresentativeDao {
    @Id
    public String id;
    public String account;
    public String customer;
    public boolean status;
}
