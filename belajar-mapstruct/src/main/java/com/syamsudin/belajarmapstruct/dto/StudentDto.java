package com.syamsudin.belajarmapstruct.dto;

import com.syamsudin.belajarmapstruct.entity.Status;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {

    private String id;

    private String fullName;

    private String email;

    private String password;

    private String address;

    private String faculty;

    private String handphone;

    private Integer age;

    private Double gpa;

    private Status studentStatus;


}
