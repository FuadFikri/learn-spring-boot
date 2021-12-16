package com.fikri.syamsudin.springboot.transaction.service;


import com.fikri.syamsudin.springboot.transaction.entity.Transaction;
import com.fikri.syamsudin.springboot.transaction.entity.TransactionType;
import com.fikri.syamsudin.springboot.transaction.entity.User;
import com.fikri.syamsudin.springboot.transaction.exception.PaymentOverBalanceException;
import com.fikri.syamsudin.springboot.transaction.exception.UserNotFoundException;
import com.fikri.syamsudin.springboot.transaction.repository.LogActivityRepository;
import com.fikri.syamsudin.springboot.transaction.repository.TransactionRepository;
import com.fikri.syamsudin.springboot.transaction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {


    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final LogActivityService logActivityService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String usernameSource, String usernameDestination, Integer amount) throws PaymentOverBalanceException {
        logActivityService.log("TRANSFER", "Start transfer from user " + usernameSource + " to user " + usernameDestination);

        User user1 =  userRepository.findByUsername(usernameSource)
                .orElseThrow(() -> new UserNotFoundException("source not found"));
        User user2 =  userRepository.findByUsername(usernameDestination)
                .orElseThrow(() -> new UserNotFoundException("destination not found"));

        logActivityService.log("TRANSFER", "Check balance from user " + user1.getUsername());
        if (user1.getBalance() < amount){
            logActivityService.log("TRANSFER", "Balance is not enough in user " + user1.getUsername());
            throw new PaymentOverBalanceException("your balance is not enough");
        }

        user1.setBalance(user1.getBalance() - amount);
        user2.setBalance(user2.getBalance() + amount);

        userRepository.saveAll(List.of(user1,user2));

        Transaction transaction1 = Transaction.builder()
                .amount(amount)
                .type(TransactionType.SEND)
                .time(LocalDateTime.now())
                .user(user1)
                .build();

        Transaction transaction2 = Transaction.builder()
                .amount(amount)
                .type(TransactionType.RECEIVE)
                .time(LocalDateTime.now())
                .user(user2)
                .build();

        transactionRepository.saveAll(List.of(transaction1,transaction2));


        logActivityService.log("TRANSFER", "End transfer from user " + user1.getUsername() + " to user " + user2.getUsername());
    }
}
