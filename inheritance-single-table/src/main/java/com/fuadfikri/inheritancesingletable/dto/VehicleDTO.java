package com.fuadfikri.inheritancesingletable.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fuadfikri.inheritancesingletable.entity.Garage;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "vehicleType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BusDTO.class, name = "Bus"),
        @JsonSubTypes.Type(value = CarDTO.class, name = "Car"),
        @JsonSubTypes.Type(value = TruckDTO.class, name = "Truck")
})
public abstract class VehicleDTO implements Serializable {

    private String id;

    private Double width;
    private Double length;

    private String manufacturer;


}
