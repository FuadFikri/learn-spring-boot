package com.fuadfikri.inheritancesingletable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuadfikri.inheritancesingletable.dto.VehicleDTO;
import com.fuadfikri.inheritancesingletable.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VehicleTest {

    @Autowired
    VehicleService vehicleService;

    @Test
    public void save(){
       String json = "{\"vehicleType\":\"Car\",\"passengerCapacity\":1,\"model\":\"sedan\",\"manufacturer\":\"honda\"}";
        VehicleDTO vehicleDTO = (VehicleDTO) this.parse(json, VehicleDTO.class);
        vehicleService.save(vehicleDTO);

    }

    public static <T> Object parse(String json, Class<T> className) {
        Object request = null;
        try {
            request = new ObjectMapper().readValue(json, className);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

        return request;
    }
}
