package com.fuadfikri.inheritancesingletable.service.mapper;

import com.fuadfikri.inheritancesingletable.dto.BusDTO;
import com.fuadfikri.inheritancesingletable.dto.CarDTO;
import com.fuadfikri.inheritancesingletable.dto.TruckDTO;
import com.fuadfikri.inheritancesingletable.entity.Bus;
import com.fuadfikri.inheritancesingletable.entity.Car;
import com.fuadfikri.inheritancesingletable.entity.Truck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Bus toEntity(BusDTO busDTO);

    Car toEntity(CarDTO carDTO);

    Truck toEntity(TruckDTO truckDTO);

}
