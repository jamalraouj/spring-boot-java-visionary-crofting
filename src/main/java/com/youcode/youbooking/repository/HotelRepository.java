package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel , Long> {

}
