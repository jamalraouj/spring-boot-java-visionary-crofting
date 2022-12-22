package com.youcode.visionarycrofting.config;

import com.youcode.visionarycrofting.entity.Role;
import com.youcode.visionarycrofting.entity.UserEntity;
import com.youcode.visionarycrofting.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner13 (UserRepository userRepository){
        return args -> {
            UserEntity admin1 = new UserEntity("jamal@gmail.com","1234");
            admin1.setRole(Role.ADMIN);
            UserEntity admin2 = new UserEntity("jamal2@gmail.com","1234");
            admin2.setRole(Role.USER);
            userRepository.saveAll(List.of(admin1,admin2));
        };

    }
}
