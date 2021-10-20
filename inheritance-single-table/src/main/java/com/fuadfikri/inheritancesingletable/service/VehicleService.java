package com.fuadfikri.inheritancesingletable.service;

import com.fuadfikri.inheritancesingletable.dto.BusDTO;
import com.fuadfikri.inheritancesingletable.dto.CarDTO;
import com.fuadfikri.inheritancesingletable.dto.TruckDTO;
import com.fuadfikri.inheritancesingletable.dto.VehicleDTO;
import com.fuadfikri.inheritancesingletable.entity.Bus;
import com.fuadfikri.inheritancesingletable.entity.Car;
import com.fuadfikri.inheritancesingletable.entity.Truck;
import com.fuadfikri.inheritancesingletable.repository.BusRepository;
import com.fuadfikri.inheritancesingletable.repository.CarRepository;
import com.fuadfikri.inheritancesingletable.repository.TruckRepository;
import com.fuadfikri.inheritancesingletable.service.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleMapper vehicleMapper;
    private final BusRepository busRepository;
    private final CarRepository carRepository;
    private final TruckRepository truckRepository;


    public void save(VehicleDTO dto){
        if (dto instanceof BusDTO){
            Bus entity = vehicleMapper.toEntity((BusDTO) dto);
            busRepository.save(entity);
        }else if (dto instanceof CarDTO ){
            log.info("saving car");
            Car entity= vehicleMapper.toEntity((CarDTO) dto);
            carRepository.save(entity);
        }else if (dto instanceof TruckDTO){
            Truck truck = vehicleMapper.toEntity((TruckDTO) dto);
            truckRepository.save(truck);
        }
    }
}
