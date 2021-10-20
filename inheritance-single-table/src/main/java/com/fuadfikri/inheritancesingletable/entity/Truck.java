package com.fuadfikri.inheritancesingletable.entity;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Truck")
public class Truck extends Vehicle{
    private Double loadCapacity;
}
