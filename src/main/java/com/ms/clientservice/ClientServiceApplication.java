package com.ms.clientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(
            ClientRepositoy clientRepositoy,
            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Client.class);
        return args -> {
            clientRepositoy.save(new Client(null,"C1","OULAHYANE Kaoutar","kaoutar.oulahyane@gmail.com"));
            clientRepositoy.save(new Client(null,"C2","ALAMI Manal","manal.alami@gmail.com"));

            clientRepositoy.findAll().forEach(client -> System.out.println(client));
        };
    }

}
