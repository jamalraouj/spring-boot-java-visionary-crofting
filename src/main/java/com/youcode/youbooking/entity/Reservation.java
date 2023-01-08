package com.youcode.youbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Chamber chamber;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Chamber chamber, LocalDate startDate, LocalDate endDate) {
        this.chamber = chamber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
