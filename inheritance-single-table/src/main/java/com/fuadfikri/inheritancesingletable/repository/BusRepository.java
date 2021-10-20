package com.fuadfikri.inheritancesingletable.repository;

import com.fuadfikri.inheritancesingletable.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, String> {
}
