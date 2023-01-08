package com.youcode.youbooking.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.youbooking.entity.Hotel} entity
 */
@Data
@NoArgsConstructor
public class HotelDto implements Serializable {
    private  String name;
    private  String description;
    private  AddressDto address;
}