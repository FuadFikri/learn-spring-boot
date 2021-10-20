package com.fuadfikri.inheritancesingletable.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("Car")
public class CarDTO  extends VehicleDTO{

    private Integer passengerCapacity;
    private String model;
}
