package com.fikri.syamsudin.springboot.transaction.service;

import com.fikri.syamsudin.springboot.transaction.entity.Rekening;
import com.fikri.syamsudin.springboot.transaction.repository.RekeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RekeningService {


    private final RekeningRepository rekeningRepository;

    public Rekening create(Rekening rekening) {
        return rekeningRepository.save(rekening);
    }

    public Iterable<Rekening> findAll() {
        return rekeningRepository.findAll();
    }



    @Transactional
    public String transfer(String rekeningAsal, String rekeningTujuan, Double amount) {
        Rekening rekening1 = rekeningRepository.findByNoRekening(rekeningAsal)
                .orElseThrow(() -> new RuntimeException("Nomor Rekening asal tidak valid"));

        if (rekening1.getSaldo() < amount){
            throw new RuntimeException("Saldo tidak cukup");
        }

        rekening1.setSaldo(rekening1.getSaldo() - amount);
        rekeningRepository.save(rekening1);

        Rekening rekening2 = rekeningRepository.findByNoRekening(rekeningTujuan)
                .orElseThrow(() -> new RuntimeException("Nomor Rekening tujuan tidak valid"));

        rekening2.setSaldo(rekening2.getSaldo() + amount);
        rekeningRepository.save(rekening2);

        return "Transfer sukses";
    }
}
