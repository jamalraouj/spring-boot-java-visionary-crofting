package com.youcode.youbooking.config;

import com.youcode.youbooking.entity.Admin;
import com.youcode.youbooking.entity.Role;
import com.youcode.youbooking.entity.UserEntity;
import com.youcode.youbooking.repository.AdminRepository;
import com.youcode.youbooking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunner17 (AdminRepository adminRepository){
        return args -> {
//            System.out.println("============>"+roleRep.findAll());
            Admin admin1 = new Admin("admin1@gmail.com","1234" , true);
//            System.out.println(admin.toString());


            Admin admin2 = new Admin("admin2@gmail.com","1234" , true);

            Admin admin3 = new Admin("admin3@gmail.com","1234" , true);

            adminRepository.saveAll(List.of(admin1,admin2 , admin3));
        };

    }
}
