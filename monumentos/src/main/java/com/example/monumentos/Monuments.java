package com.example.monumentos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monuments {
    private Long id;
    private String countryName;
    private String monumentName;
    private String cityName;
    private String description;
    private String image;
    private double latitude;
    private double longitude;
    private double countryIsoCode;
}
