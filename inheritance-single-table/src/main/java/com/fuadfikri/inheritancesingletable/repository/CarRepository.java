package com.fuadfikri.inheritancesingletable.repository;

import com.fuadfikri.inheritancesingletable.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
