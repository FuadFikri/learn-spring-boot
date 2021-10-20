package com.fuadfikri.inheritancesingletable.dto;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("Bus")
public class BusDTO  extends VehicleDTO{

    private Integer passengerCapacity;
}
