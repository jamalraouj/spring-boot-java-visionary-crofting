package com.youcode.youbooking.config;

import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.ChamberType;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.repository.HotelRepository;
import com.youcode.youbooking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HotelConfig {
    @Bean
    CommandLineRunner commandLineRunner14 (HotelRepository hotelRepository){

        return args -> {
            Chamber c1 = new Chamber("name1" , "desc1","img1", ChamberType.SINGLE);
            Chamber c2 = new Chamber("name2" , "desc2","img2",ChamberType.SINGLE);
            Chamber c3 = new Chamber("name3" , "desc3","img3",ChamberType.PRESIDENTIAL);
            Chamber c4 = new Chamber("name4" , "desc4","img4",ChamberType.TWIN);
            Chamber c5 = new Chamber("name5" , "desc5","img5",ChamberType.DOUBLE);

            Hotel h1  = new Hotel("hotel 1" , "description");
            Hotel h2  = new Hotel("hotel 2" , "description2");
            Hotel h3  = new Hotel("hotel 3" , "description3");

//            h1.setChamberList(List.of(c1,c2,c3));
//            h2.setChamberList(List.of(c4,c5));
//            h1.addChamber(c1);
//            h1.addChamber(c2);

            hotelRepository.saveAll(List.of(h1,h2,h3));
        };
    }

}
