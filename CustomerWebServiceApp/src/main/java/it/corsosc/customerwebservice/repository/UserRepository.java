package it.corsosc.customerwebservice.repository;

import it.corsosc.customerwebservice.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Account, Integer> {

    public Account findByUsername(String username);
}
