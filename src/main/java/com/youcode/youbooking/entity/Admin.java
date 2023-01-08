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
public class Admin extends UserEntity {

    public Admin(String email, String password, Boolean isActive) {
        super(email, password, isActive, Role.ADMIN);
    }

    @OneToMany
    private List<Announcement> announcementList = new ArrayList<>();

    public Admin() {

    }
}
