package com.youcode.youbooking.repository;

import com.youcode.youbooking.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement , Long> {
}
