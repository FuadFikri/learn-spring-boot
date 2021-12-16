package com.fuadfikri.inheritancesingletable.controller;

import com.fuadfikri.inheritancesingletable.dto.VehicleDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {

    @PostMapping("/create")
    public void create(@RequestBody VehicleDTO vehicleDTO){
        System.out.println("okokok");
    }
}
