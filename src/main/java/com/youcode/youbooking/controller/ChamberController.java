package com.youcode.youbooking.controller;

import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.entity.Reservation;
import com.youcode.youbooking.service.ChamberService;
import com.youcode.youbooking.service.HotelService;
import com.youcode.youbooking.service.ReservationService;
import com.youcode.youbooking.service.dto.ChamberDto;
import com.youcode.youbooking.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/youbooking/chambers")
public class ChamberController {
    @Autowired
    ChamberService chamberService;
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Chamber> getAll(){
        return chamberService.findAll();
    }

    @PostMapping("/add/{id_hotel}")
    public ResponseEntity<Chamber> add(@RequestBody Chamber chamber , @PathVariable Long id_hotel){

        return ResponseEntity.ok(chamberService.add(chamber , id_hotel));
    }

    @PostMapping("/reserve")
    public ResponseEntity<Reservation> reserve(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.add(reservationDTO));
    }
    @GetMapping("/all/reserve")
    public ResponseEntity<List<Reservation>> allreserve(){
        return ResponseEntity.ok(reservationService.findAll());
    }

}
