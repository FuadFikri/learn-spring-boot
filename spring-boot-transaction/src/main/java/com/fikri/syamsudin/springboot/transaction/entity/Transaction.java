package com.fikri.syamsudin.springboot.transaction.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Integer amount;


    private LocalDateTime time;

    @NotNull
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

}
