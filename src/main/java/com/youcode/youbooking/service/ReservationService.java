package com.youcode.youbooking.service;

import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Hotel;
import com.youcode.youbooking.entity.Reservation;
import com.youcode.youbooking.repository.ChamberRepository;
import com.youcode.youbooking.repository.HotelRepository;
import com.youcode.youbooking.repository.ReservationRepository;
import com.youcode.youbooking.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IService<Reservation , Long> {

    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public Reservation add(Reservation reservation) {
        return null;
    }

    public Reservation add(ReservationDTO reservationDTO) {
        System.out.println(reservationDTO);
            Optional<Chamber> chamber = chamberRepository.findById(reservationDTO.getRoomId());
            if (chamber.isPresent()){
                Chamber chamber1 = reservationRepository.findChamberAndDateRange(chamber.get().getId() , reservationDTO.getStartDate() , reservationDTO.getEndDate());
                Reservation reservation = new Reservation(chamber.get(), LocalDate.of(2023,01,07) , LocalDate.of(2023,01,10));
                return reservationRepository.save(reservation);
            }
            return null;
    }

    @Override
    public boolean delete(Long i) {
        return false;
    }

    @Override
    public Reservation findOneById(Long i) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
