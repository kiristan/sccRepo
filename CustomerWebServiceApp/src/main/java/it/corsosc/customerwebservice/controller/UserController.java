package it.corsosc.customerwebservice.controller;

import it.corsosc.customerwebservice.entity.Account;
import it.corsosc.customerwebservice.entity.Cliente;
import it.corsosc.customerwebservice.service.CustomerService;
import it.corsosc.customerwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/cliente")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/findAccount/{username}", produces = "application/json")
    public ResponseEntity<Account> findbyIdAccount(@PathVariable("username") String username){
        return new ResponseEntity<Account>(userService.findAccountByUsername(username),HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/findClienteByAccountUsername/{username}", produces = "application/json")
    public ResponseEntity<Cliente> findClienteByAccountUsername(@PathVariable("username") String username){
        Account account = userService.findAccountByUsername(username);
        Cliente cliente = customerService.findByAccountId(account.getId());
        System.out.println("Recuperato "+cliente);
        return new ResponseEntity<Cliente>(cliente ,HttpStatus.OK);
    }

}