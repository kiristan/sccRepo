package it.corsosc.customerwebservice.service;

import it.corsosc.customerwebservice.entity.Account;
import it.corsosc.customerwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository filmRepository;


    @Override
    public Account findAccountByUsername(String username) {
        return filmRepository.findByUsername(username);
    }
}
