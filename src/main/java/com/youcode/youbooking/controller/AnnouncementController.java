package com.youcode.youbooking.controller;

import com.youcode.youbooking.entity.Announcement;
import com.youcode.youbooking.service.AnnouncementService;
import com.youcode.youbooking.service.dto.AnnounceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youbooking/announcement")
public class AnnouncementController {
//create api annoncement
    @Autowired
    AnnouncementService announcementService;
//    @PostMapping("/add")
//    public Announcement add(@RequestBody AnnounceDTO announceDTO){
//        return announcementService.add(announceDTO);
//    }
    }
