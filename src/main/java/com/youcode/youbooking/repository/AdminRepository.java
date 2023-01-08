package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
