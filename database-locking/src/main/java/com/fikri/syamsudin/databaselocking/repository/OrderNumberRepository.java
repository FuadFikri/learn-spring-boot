package com.fikri.syamsudin.databaselocking.repository;

import com.fikri.syamsudin.databaselocking.entity.OrderNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderNumberRepository extends CrudRepository<OrderNumber, String> {

    Optional<OrderNumber> findByPrefix(String prefix);
}
