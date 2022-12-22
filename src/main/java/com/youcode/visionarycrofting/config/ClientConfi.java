package com.youcode.visionarycrofting.config;

import com.youcode.visionarycrofting.entity.Client;
import com.youcode.visionarycrofting.entity.Product;
import com.youcode.visionarycrofting.entity.Role;
import com.youcode.visionarycrofting.repository.ClientRepository;
import com.youcode.visionarycrofting.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class ClientConfi {
    @Bean
    CommandLineRunner commandLineRunner1 (ClientRepository clientRepository){
        return args -> {
            Client client1=new Client("PASS132","0634483769","YOUSOUFIA");
            client1.setRole(Role.CLIENT);
            client1.setEmail("client@gmail.com");
            client1.setPassword("1234");

            Client client=new Client("PASS132","0634483769","YOUSOUFIA");
            client.setEmail("client2@gmail.com");
            client.setPassword("1234");
            client.setRole(Role.CLIENT);
           clientRepository.saveAll(List.of(client1,client));
        };
    }
}
