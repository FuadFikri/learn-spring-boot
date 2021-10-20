package com.fuadfikri.inheritancesingletable.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@JsonTypeName("Truck")
@Data
public class TruckDTO extends VehicleDTO {
    private Double loadCapacity;
}
