package com.youcode.youbooking.service;

import com.youcode.youbooking.classes.Message;
import com.youcode.youbooking.entity.*;
import com.youcode.youbooking.repository.*;
import com.youcode.youbooking.service.dto.AddressDto;
import com.youcode.youbooking.service.dto.AnnounceDTO;
import com.youcode.youbooking.service.dto.HotelDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class AnnouncementService implements IService<Announcement,Long> {
    @Autowired
    AnnouncementRepository announcementRepository;
    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ProprietaryRepository proprietaryRepository;
    @Override
    public Announcement add(Announcement announcement){
        return  null;
    }
    @Transactional
    public Announcement add(AnnounceDTO announceDTO , Principal principal){
        Announcement announcement = new Announcement();
        Message message = new Message();
        if(announceDTO != new AnnounceDTO()){
            if(announceDTO.getAnnounceRef() == null || announceDTO.getAnnounceRef()=="") {
                announceDTO.setAnnounceRef(UUID.randomUUID().toString());
            }if (!announceDTO.getHotel().equals(new HotelDto())){
                if (announceDTO.getHotel().getName() != null && announceDTO.getHotel().getName()!="" && announceDTO.getHotel().getDescription() != null && announceDTO.getHotel().getDescription()!="") {
                    if(announceDTO.getHotel().getAddress()!=new AddressDto()) {
                        if (announceDTO.getHotel().getAddress().getAddress() != "" && announceDTO.getHotel().getAddress().getAddress()!=null && announceDTO.getHotel().getAddress().getCity() != "" && announceDTO.getHotel().getAddress().getCountry() != ""){

                            Hotel hotel = new Hotel();
                            Address address = new Address();
                            BeanUtils.copyProperties(announceDTO.getHotel(), hotel);
                            BeanUtils.copyProperties(announceDTO.getHotel().getAddress(), address);

                            announcement.setRef(announceDTO.getAnnounceRef());
                            addressRepository.save(address);
                            hotel.setAddress(address);
                            hotelRepository.save(hotel);
                            announcement.setHotel(hotel);
                            announcementRepository.save(announcement);
                            Proprietary proprietary = proprietaryRepository.findByEmail(principal.getName());
                            proprietary.addAnnouncement(announcement);

                            proprietaryRepository.save(proprietary);

                    }else {
                        message.setMessage("some details of hotel Address is null");
                        message.setState("ERROR");
                    }}else {
                        message.setMessage("Address of hotel is null");
                        message.setState("ERROR");
                    }
                }else {
                    message.setMessage("Name or description are null");
                    message.setState("ERROR");
                }
            }else {
                message.setMessage("hotel is null");
                message.setState("ERROR");
            }

         }else {
            message.setMessage("data is null");
            message.setState("ERROR");
        }
        announcement.setMessage(message);
        return announcement;
    }


//    public Announcement add(AnnounceDTO announceDTO) {
//
//        Optional<Announcement> announcement = null;
//        Message message = new Message();
//        if(announceDTO.getIdHotel() >= 0 || announceDTO.getIdHotel() != null){
//            if(announceDTO.getId_chamber() >=0 || announceDTO.getId_chamber() != null){
//                if(announceDTO.getAnnounceRef() != null && announceDTO.getAnnounceRef() != ""){
//                    Optional<Hotel> hotel = hotelRepository.findById(announceDTO.getIdHotel());
//                    if(hotel.isPresent()){
//                        Chamber chamber = (Chamber) hotel.get().getChamberList().stream().filter(ch -> ch.getId() == announceDTO.getId_chamber());
//                        announcement.get().setChamber( chamber);
//                        announcement.get().setRef(announceDTO.getAnnounceRef());
//                        announcementRepository.save(announcement.get());
//                    }
//                }else {
//                    message.setMessage("reference of an announce is null");
//                    message.setState("ERROR");
//                }
//            }else {
//                message.setMessage("chamber is null");
//                message.setState("ERROR");
//            }
//        }
//        else {
//            message.setMessage("hotel is null");
//            message.setState("ERROR");
//        }
////        if(announce.isPresent()){
//////            Optional<Hotel> hotel = hotelRepository.findById(idHotel);
//////            if(hotel.isPresent()) {
//////
//////                announce.get().getChamber().getAnnouncement().getChamber().getAnnouncement().getChamber()
//////                chamberRepository.save();
//////                announcementRepository.save(announce.get());
//////            }
////        }
//        return announcement.get();
//    }

    @Override
    public boolean delete(Long i) {
        return false;
    }

    @Override
    public Announcement findOneById(Long i) {
        return null;
    }

    @Override
    public Announcement update(Announcement announcement) {
        return null;
    }

    @Override
    public List<Announcement> findAll() {
        return null;
    }

    public List<Announcement> getAnnouncesByProp(Long id_prop) {
        return null;
    }
}
