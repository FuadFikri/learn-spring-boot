package com.fikri.syamsudin.databaselocking.repository;

import com.fikri.syamsudin.databaselocking.entity.OrderNumber;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface OrderNumberRepository extends CrudRepository<OrderNumber, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<OrderNumber> findByPrefix(String prefix);
}
