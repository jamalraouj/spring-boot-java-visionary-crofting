package com.youcode.youbooking.entity;



import com.youcode.youbooking.classes.Message;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne
    private Address address;
    @OneToOne
    private Announcement announcement;
//    @OneToMany(mappedBy ="hotel")//fetch = FetchType.EAGER
    @OneToMany//, cascade = CascadeType.ALL
    private List<Chamber> chamberList ;
    @Transient
    private Message message;

    public Hotel(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void addChamber(Chamber chamber){
        this.chamberList.add(chamber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Chamber> getChamberList() {
        return chamberList;
    }

    public void setChamberList(List<Chamber> chamberList) {
        this.chamberList = chamberList;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


}
