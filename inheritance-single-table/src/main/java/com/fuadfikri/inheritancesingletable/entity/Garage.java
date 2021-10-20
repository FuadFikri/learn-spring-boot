package com.fuadfikri.inheritancesingletable.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Garage {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private String name;

    private String locationCode;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garage", orphanRemoval = true)
    private List<Vehicle> vehicles;



}
