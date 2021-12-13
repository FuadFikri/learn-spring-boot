package com.fikri.syamsudin.springboot.transaction.repository;

import com.fikri.syamsudin.springboot.transaction.entity.LogActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActivityRepository extends CrudRepository<LogActivity, Integer> {
}
