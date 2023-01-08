package com.youcode.youbooking.controller;

import com.youcode.youbooking.controller.vm.ResponseVm;
import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = {"/youbooking/hotel"})
public class HotelController {
    @Autowired
    HotelService hotelService;
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Hotel>> getAll(){
        System.out.println(true);
        List<Hotel> hotels = hotelService.findAll();
        return ResponseEntity.ok(hotels);
    }
    @GetMapping(path="/get/{id}")
    public Hotel getOne(@PathVariable Long id){
        return hotelService.findOneById(id);
    }
    @PostMapping("/add")
    public Hotel add(@RequestBody Hotel hotel){
        return hotelService.add(hotel);
    }
    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return hotelService.delete(id);
    }
//    @PostMapping("/chambers/add/{id_hotel}")
//    public Hotel addChamber(@RequestBody Chamber chamber , @PathVariable Long id_hotel){
//        return hotelService.addChamber(chamber , id_hotel);
//    }

}
