package com.youcode.youbooking.service;

import com.youcode.youbooking.classes.Message;
import com.youcode.youbooking.entity.Announcement;
import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.entity.Proprietary;
import com.youcode.youbooking.repository.HotelRepository;
import com.youcode.youbooking.repository.ProprietaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IService<Hotel , Long>{
    Principal principal;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ChamberService chamberService;
    @Autowired
    ProprietaryService proprietaryService;
    @Autowired
    ProprietaryRepository proprietaryRepository;
    @Override
    @Transactional
    public Hotel add(Hotel hotel) {
        Optional<Proprietary> proprietary = proprietaryRepository.findById(Long.parseLong("4"));
        if(proprietary.isPresent()){
            hotelRepository.save(hotel);
            proprietary.get().addHotel(hotel);
            proprietaryService.add(proprietary.get());
        }
        return hotel;
    }
    public List<Hotel> getMyHotel(Principal principal) {

        Optional<Proprietary> proprietary = Optional.ofNullable(proprietaryRepository.findByEmail(principal.getName()));
        return proprietary.get().getHotelList();
    }

    @Override
    public boolean delete(Long id) {
        if(hotelRepository.existsById(id)){
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Hotel findOneById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        Message message = new Message();
        if(hotel.isPresent()){
            message.setMessage("SUCCESS");
            message.setState("SUCCESS");

        }
        else {
            message.setMessage("not found this hotel");
            message.setState("ERROR");
        }
        hotel.get().setMessage(message);
        return hotel.get();
    }

    @Override
    public Hotel update(Hotel hotel) {
        return null;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public List<Announcement> getMyAnnounces(Principal principal) {
        Optional<Proprietary> proprietary = Optional.ofNullable(proprietaryRepository.findByEmail(principal.getName()));
        return proprietary.get().getAnnouncementList();
    }

    public List<Chamber> getMyChambers(Long id_hotel ,Principal principal) {
        Optional<Proprietary> proprietary = Optional.ofNullable(proprietaryRepository.findByEmail(principal.getName()));

        Hotel hotel1 = (Hotel) proprietary.get().getHotelList().stream().filter(hotel -> hotel.getId() == id_hotel );

        return hotel1.getChamberList();
    }

//    public Hotel addChamber(Chamber chamber, Long id_hotel) {
//        Message message = new Message();
//        Optional<Hotel> hotel = Optional.of(new Hotel());
//        if(chamber == new Chamber()){
//            message.setMessage("chamber is null");
//            message.setState("ERROR");
//        }
//        else if(id_hotel == null){
//            message.setMessage("id is null");
//            message.setState("ERROR");
//        }
//        else if(hotelRepository.existsById(id_hotel)){
//            hotel = hotelRepository.findById(id_hotel);
//            if(hotel.isPresent()) {
//
//                chamber.setHotel(hotel.get());
//
//                chamberService.add(chamber);
//            }
//        }
//        hotel.get().setMessage(message);
//        return hotel.get();
//    }
}
