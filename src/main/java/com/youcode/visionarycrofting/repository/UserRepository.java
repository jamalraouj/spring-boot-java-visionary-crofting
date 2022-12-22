package com.youcode.visionarycrofting.repository;

import com.youcode.visionarycrofting.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserByEmail(String email);

}
