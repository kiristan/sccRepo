package it.corsosc.customerwebservice.service;

import it.corsosc.customerwebservice.entity.Account;
import it.corsosc.customerwebservice.entity.Cliente;
import it.corsosc.customerwebservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Cliente findByAccountId(Integer accountId) {
        return customerRepository.findByAccountId(accountId);
    }
}
