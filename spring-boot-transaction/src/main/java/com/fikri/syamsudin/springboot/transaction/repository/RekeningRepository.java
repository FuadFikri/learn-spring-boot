package com.fikri.syamsudin.springboot.transaction.repository;

import com.fikri.syamsudin.springboot.transaction.entity.Rekening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RekeningRepository extends CrudRepository<Rekening, Integer> {

    Optional<Rekening> findByNoRekening(String noRek);
}
