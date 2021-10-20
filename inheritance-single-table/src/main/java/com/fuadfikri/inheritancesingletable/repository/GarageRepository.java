package com.fuadfikri.inheritancesingletable.repository;


import com.fuadfikri.inheritancesingletable.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GarageRepository extends JpaRepository<Garage, String> {
}
