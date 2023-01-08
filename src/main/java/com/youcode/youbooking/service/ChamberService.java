package com.youcode.youbooking.service;

import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.repository.ChamberRepository;
import com.youcode.youbooking.repository.HotelRepository;
import com.youcode.youbooking.service.dto.ChamberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ChamberService implements IService<Chamber , Long> {
    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    HotelRepository hotelRepository2;
    @Override
    public Chamber add(Chamber chamber) {

        return chamberRepository.save(chamber);
    }

    public Chamber add(Chamber chamber , Long id_hotel){
        Optional<Hotel> hotel =  hotelRepository2.findById(id_hotel);
        if(hotel.isPresent()) {
//            chamber.setHotel(hotel.get());
            chamberRepository.save(chamber);
            hotel.get().addChamber(chamber);
            hotelRepository2.save(hotel.get());
        }
         return chamber ;
    }
    @Override
    public boolean delete(Long i) {
        return false;
    }
    @Override
    public Chamber findOneById(Long i) {
        return null;
    }

    @Override
    public Chamber update(Chamber chamber) {
        return null;
    }

    @Override
    public List<Chamber> findAll() {
        return chamberRepository.findAll();
    }

//    private StudentDto convertToDto(Student student) {
//        return modelMapper..mapModels(student, StudentDto.class);
//    }


}
