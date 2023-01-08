package com.youcode.youbooking.entity;

import com.youcode.youbooking.classes.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private LocalDate localDate ;
//    @ManyToOne(cascade=CascadeType.PERSIST)
//@JoinColumn(name="cidade_id")
    private boolean is_accept = false;
    @OneToOne(orphanRemoval = true ,cascade = CascadeType.REMOVE)
    private Hotel hotel;


    public Announcement(String ref, Hotel hotel) {
        this.ref = ref;
        this.hotel = hotel;
        this.localDate = LocalDate.now();
    }
    @Transient
    Message message;
}
