package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Proprietary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaryRepository extends JpaRepository<Proprietary , Long> {
    Proprietary findByEmail(String name);
}
