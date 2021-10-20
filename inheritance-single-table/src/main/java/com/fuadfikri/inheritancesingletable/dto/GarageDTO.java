package com.fuadfikri.inheritancesingletable.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GarageDTO implements Serializable {
    private String id;

    private String name;

    private String locationCode;


    private List<VehicleDTO> vehicles;
}
