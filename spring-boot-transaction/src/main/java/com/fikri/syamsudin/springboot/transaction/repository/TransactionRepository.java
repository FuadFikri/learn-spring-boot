package com.fikri.syamsudin.springboot.transaction.repository;

import com.fikri.syamsudin.springboot.transaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
