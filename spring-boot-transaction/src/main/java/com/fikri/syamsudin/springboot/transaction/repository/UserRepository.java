package com.fikri.syamsudin.springboot.transaction.repository;

import com.fikri.syamsudin.springboot.transaction.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
