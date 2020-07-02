package com.gemellaro.config;

import com.gemellaro.config.FeignClientConfiguration;
import com.gemellaro.dto.Cliente;
import com.gemellaro.security.Account;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "customerClientService", url = "http://localhost:8065", configuration = FeignClientConfiguration.class)
//@FeignClient(name = "customer-client-service", configuration = FeignClientConfiguration.class)
//@RibbonClient(name = "customer-client-service")
@FeignClient(name = "customerwebservice", configuration = FeignClientConfiguration.class)
@RibbonClient(name = "customerwebservice")
public interface CustomerClient {

    @GetMapping(value = "/movieondemand/rest/cliente/findClienteByAccountUsername/{username}")
    public Cliente getInfoCliente(@PathVariable("username") String username);

    @GetMapping(value = "/movieondemand/rest/cliente/findAccount/{username}")
    public Account getInfoAccount(@PathVariable("username") String username);
}