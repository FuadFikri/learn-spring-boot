package com.syamsudin.belajarmapstruct.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data

public class Student implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String faculty;
    private String handphone;
    private LocalDate birthDate;
    private Double gpa;
    private Status studentStatus;
}
