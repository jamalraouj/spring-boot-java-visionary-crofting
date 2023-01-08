package com.youcode.youbooking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;

@Setter
@Getter
@NoArgsConstructor
public class ReservationDTO implements Serializable{
        private LocalDate startDate;
        private LocalDate endDate;
        private Long roomId;

        public ReservationDTO(LocalDate startDate, LocalDate endDate, Long roomId) {
                this.startDate = LocalDate.now(ZoneId.from(startDate));
                this.endDate = LocalDate.now(ZoneId.from(endDate));
                this.roomId = roomId;
        }
}
