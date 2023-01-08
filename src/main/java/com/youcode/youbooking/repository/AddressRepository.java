package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address ,Long> {
}
