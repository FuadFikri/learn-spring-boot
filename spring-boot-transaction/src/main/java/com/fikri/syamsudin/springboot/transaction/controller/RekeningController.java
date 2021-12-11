package com.fikri.syamsudin.springboot.transaction.controller;

import com.fikri.syamsudin.springboot.transaction.dto.TransferRequest;
import com.fikri.syamsudin.springboot.transaction.entity.Rekening;
import com.fikri.syamsudin.springboot.transaction.service.RekeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rekening")
public class RekeningController {

    private final RekeningService rekeningService;



    @PostMapping
    Rekening create(@RequestBody Rekening rekening) {
        return rekeningService.create(rekening);
    }

    @GetMapping
    Iterable<Rekening> findAll(){
        return rekeningService.findAll();
    }


    @PostMapping("/transfer")
    String transfer (@RequestBody TransferRequest request){
        return rekeningService.transfer(request.getNoRekening1(), request.getNoRekening2(), request.getAmount());
    }

}
