package com.youcode.youbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter

public class Proprietary extends UserEntity {
    public Proprietary(String email, String password, Boolean isActive) {
        super(email, password, isActive, Role.PROPRIETARY);
    }

    @OneToMany
    private List<Hotel> hotelList = new ArrayList<>();

    @OneToMany
    private List<Announcement> announcementList = new ArrayList<>();

    public Proprietary() {

    }


    public void addAnnouncement(Announcement announcement){
        this.announcementList.add(announcement);
    }

    public void addHotel(Hotel hotel){
        this.hotelList.add(hotel);
    }

}
