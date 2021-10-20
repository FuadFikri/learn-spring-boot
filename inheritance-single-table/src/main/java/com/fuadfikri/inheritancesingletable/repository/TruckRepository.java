package com.fuadfikri.inheritancesingletable.repository;

import com.fuadfikri.inheritancesingletable.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, String> {
}
