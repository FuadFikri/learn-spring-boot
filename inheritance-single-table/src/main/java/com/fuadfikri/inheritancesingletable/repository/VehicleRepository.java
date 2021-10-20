package com.fuadfikri.inheritancesingletable.repository;

import com.fuadfikri.inheritancesingletable.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
