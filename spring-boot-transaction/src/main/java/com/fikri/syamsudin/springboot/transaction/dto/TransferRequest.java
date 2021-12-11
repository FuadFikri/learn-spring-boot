package com.fikri.syamsudin.springboot.transaction.dto;

import lombok.Data;

@Data
public class TransferRequest {
    private String noRekening1;
    private String noRekening2;
    private Double amount;
}
