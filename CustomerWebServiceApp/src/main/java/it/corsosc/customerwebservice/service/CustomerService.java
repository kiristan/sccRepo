package it.corsosc.customerwebservice.service;

import it.corsosc.customerwebservice.entity.Account;
import it.corsosc.customerwebservice.entity.Cliente;

public interface CustomerService {

    public Cliente findByAccountId(Integer accountId);
}
