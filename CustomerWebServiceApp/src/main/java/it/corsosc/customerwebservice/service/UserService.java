package it.corsosc.customerwebservice.service;

import it.corsosc.customerwebservice.entity.Account;

public interface UserService {

    public Account findAccountByUsername(String username);
}
