package com.banck.representative.domain;

import lombok.Data;

@Data
public class Representative {
    public String id;
    public String account;
    public String customer;
    public boolean status;
}
