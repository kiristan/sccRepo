package it.springcs.configserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigservApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigservApplication.class, args);
    }

}
