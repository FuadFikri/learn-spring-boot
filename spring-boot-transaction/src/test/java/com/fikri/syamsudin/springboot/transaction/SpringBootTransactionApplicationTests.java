package com.fikri.syamsudin.springboot.transaction;

import com.fikri.syamsudin.springboot.transaction.entity.User;
import com.fikri.syamsudin.springboot.transaction.exception.PaymentOverBalanceException;
import com.fikri.syamsudin.springboot.transaction.repository.LogActivityRepository;
import com.fikri.syamsudin.springboot.transaction.repository.TransactionRepository;
import com.fikri.syamsudin.springboot.transaction.repository.UserRepository;
import com.fikri.syamsudin.springboot.transaction.service.TransactionService;
import com.fikri.syamsudin.springboot.transaction.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class SpringBootTransactionApplicationTests {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LogActivityRepository logActivityRepository;

    @Test
    public void insertUser() {
        User user1 = User.builder()
                .username("Fikri")
                .balance(1000)
                .build();

        User user2 = User.builder()
                .username("Isna")
                .balance(2000)
                .build();

        userRepository.saveAll(List.of(user1, user2));
    }


    @Test
    public void transferFail()  {
        Assertions.assertThrows(PaymentOverBalanceException.class, () -> {
            transactionService.transfer("Isna", "Fikri", 5000);
        });


    }

    @Test
    public void transferSuccess() throws PaymentOverBalanceException {
        transactionService.transfer("Isna", "Fikri", 200);

        Optional<User> user1  = userRepository.findByUsername("Fikri");
        Optional<User> user2  = userRepository.findByUsername("Isna");

        Assertions.assertEquals(1200, user1.get().getBalance());
        Assertions.assertEquals(1800, user2.get().getBalance());
    }

    @Test
    public void clearData() {
        userRepository.deleteAll();
        transactionRepository.deleteAll();
        logActivityRepository.deleteAll();
    }

}
