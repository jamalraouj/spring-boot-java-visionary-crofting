package com.youcode.youbooking.controller;

import com.youcode.youbooking.entity.Announcement;
import com.youcode.youbooking.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/youbooking/admin")
public class AdminController {
    @Autowired
    AnnouncementService announcementService;

    @GetMapping("/get-all-announces")
    public List<Announcement> getAllAnnounces(){
        return announcementService.findAll();
    }
    @GetMapping("/get-all-announces/{id_prop}")
    public List<Announcement> getAllAnnounces(@PathVariable Long id_prop){
        return announcementService.getAnnouncesByProp(id_prop);
    }
}
