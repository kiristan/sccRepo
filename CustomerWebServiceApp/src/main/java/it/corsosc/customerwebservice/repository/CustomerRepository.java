package it.corsosc.customerwebservice.repository;

import it.corsosc.customerwebservice.entity.Account;
import it.corsosc.customerwebservice.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Cliente, Integer> {

    public Cliente findByAccountId(Integer accountId);
}
