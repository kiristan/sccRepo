package com.gemellaro.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemellaro.security.Account;
import com.gemellaro.security.UserConfig;


@Service(value = "myCustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserConfig uc;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.length() < 3) {
            throw new UsernameNotFoundException("Nome utente non valido!");
        }
        Account account = this.getHttpValue(username);
        if (account == null) {
            throw new UsernameNotFoundException("Utente non trovato!");
        }
        UserBuilder builder = User.withUsername(account.getUsername());
        builder.disabled(false);
        builder.password(account.getPassword());
        builder.authorities("ROLE_" + account.getRole());
        return builder.build();
    }

    private Account getHttpValue(String username) {
        URI url = null;
        try {
            url = new URI(uc.getServiceUrl() + username);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(uc.getUserId(), uc.getPassword()));
        Account a = restTemplate.getForObject(url, Account.class);
        return a;
    }

}
