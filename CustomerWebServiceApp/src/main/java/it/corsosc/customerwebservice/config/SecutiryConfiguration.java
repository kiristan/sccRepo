package it.corsosc.customerwebservice.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecutiryConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] ADMIN_MATCHER = {"/rest/cliente/**"};
    private static final String[] USER_MATCHER = {"/rest/account/**"};

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserBuilder users = User.builder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //System.out.println("TEST_  :  "+ new BCryptPasswordEncoder().encode("tommy"));
        manager.createUser(
                users.username("pippo").password(new BCryptPasswordEncoder().encode("java"))
                        .roles("ADMIN","USER").build()
        );
        manager.createUser(
                users.username("pluto").password(new BCryptPasswordEncoder().encode("java"))
                        .roles("USER").build()
        );
        manager.createUser(
                users.username("qwerty").password(new BCryptPasswordEncoder().encode("java"))
                        .roles("ACTUATOR").build()
        );
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder((new BCryptPasswordEncoder()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers((EndpointRequest.to("info"))).permitAll()
                .requestMatchers((EndpointRequest.toAnyEndpoint())).hasRole("ACTUATOR")
                .antMatchers(ADMIN_MATCHER).hasRole("ADMIN")
                .antMatchers(USER_MATCHER).hasRole("USER")
                .and().httpBasic().and().csrf().disable();
    }


}
