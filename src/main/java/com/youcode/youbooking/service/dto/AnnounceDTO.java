package com.youcode.youbooking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnnounceDTO implements Serializable {

    private String announceRef;
    private HotelDto hotel;
}
