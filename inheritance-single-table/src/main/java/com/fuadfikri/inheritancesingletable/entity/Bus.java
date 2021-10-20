package com.fuadfikri.inheritancesingletable.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Bus")
public class Bus extends Vehicle{
    private Integer passengerCapacity;

}
