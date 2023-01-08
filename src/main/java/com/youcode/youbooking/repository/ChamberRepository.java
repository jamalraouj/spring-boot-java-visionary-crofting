package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ChamberRepository extends JpaRepository<Chamber,Long> {
}

