package com.youcode.youbooking.config;

import com.youcode.youbooking.entity.Admin;
import com.youcode.youbooking.entity.Proprietary;
import com.youcode.youbooking.repository.AdminRepository;
import com.youcode.youbooking.repository.ProprietaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PropConfig {
    @Bean
    CommandLineRunner commandLineRunner16 (ProprietaryRepository proprietaryRepository){
        return args -> {
//            System.out.println("============>"+roleRep.findAll());
            Proprietary p1 = new Proprietary("p1@gmail.com","1234" , true);
//            System.out.println(admin.toString());


            Proprietary p2 = new Proprietary("p2@gmail.com","1234" , true);

            Proprietary p3 = new Proprietary("p3@gmail.com","1234" , true);

            proprietaryRepository.saveAll(List.of(p1,p2 , p3));
        };

    }
}
