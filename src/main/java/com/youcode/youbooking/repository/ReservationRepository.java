package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Chamber;
import com.youcode.youbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    //this query is not ran try use pgAdmin query
    @Query("SELECT r FROM Chamber c inner join Reservation r WHERE r.chamber.id = :idChamber AND r.startDate = :startDate AND r.endDate = :endDate")
    Chamber findChamberAndDateRange(
            @Param("idChamber") Long idChamber,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
