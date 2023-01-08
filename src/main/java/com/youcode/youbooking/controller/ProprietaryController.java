package com.youcode.youbooking.controller;

import com.youcode.youbooking.entity.Announcement;
import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.service.AnnouncementService;
import com.youcode.youbooking.service.ChamberService;
import com.youcode.youbooking.service.HotelService;
import com.youcode.youbooking.service.dto.AnnounceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/youbooking/proprietary")
public class ProprietaryController {
    @Autowired
    HotelService hotelService;
    @Autowired
    ChamberService chamberService;
    @Autowired
    AnnouncementService announcementService;
    @PostMapping("/add-hotel")
    public Hotel addHotel(@RequestBody Hotel hotel ){
        return hotelService.add(hotel);
    }
    @PostMapping("/add-announce")
    public Announcement addHotel(@RequestBody @Valid AnnounceDTO announceDTO , Principal principal){
        return announcementService.add(announceDTO , principal);
    }
    @GetMapping(path = {"/get-my-hotel","/",""})
    public ResponseEntity<List<Hotel>> getListHotel(Principal principal){
        System.out.println(true);
        return ResponseEntity.ok(hotelService.getMyHotel(principal));

    }
    @GetMapping("/get-my-announces")
    public List<Announcement> getListAnnounce(Principal principal){
        return hotelService.getMyAnnounces(principal);
    }
    @GetMapping("/get-my-chambers/{id_hotel}")
    public List<Chamber> getListChamersByHotel(@PathVariable Long id_hotel ,Principal principal){
        return hotelService.getMyChambers(id_hotel, principal);
    }
    @PostMapping("/get-my-hotel/chamber/add/{id_hotel}")
    public ResponseEntity<Chamber> addChamber(@RequestBody Chamber chamber , @PathVariable Long id_hotel){
        return ResponseEntity.ok(chamberService.add(chamber , id_hotel));
    }
}
