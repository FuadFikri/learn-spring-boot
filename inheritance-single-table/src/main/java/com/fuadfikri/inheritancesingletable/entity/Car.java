package com.fuadfikri.inheritancesingletable.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {

    private Integer passengerCapacity;
    private String model;

}
