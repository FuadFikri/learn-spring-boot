package com.fikri.syamsudin.databaselocking;

import com.fikri.syamsudin.databaselocking.service.OrderNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderNumberTest {

    @Autowired
    private OrderNumberService orderNumberService;

    @Test
    public void getNumberTest() {
        Long result = orderNumberService.getNumber("21L00");
        Assertions.assertNotNull(result);
        System.out.println("order number result = " + result);
    }


    @Test
    public void generateNumberMultiThread() throws InterruptedException {
        int jumlahThread = 2;


        for (int i = 0; i < jumlahThread; i++) {


            Thread t = new Thread(() -> {

                Long result = orderNumberService.getNumber("21L00");
                System.out.println("order number result = " + result);

            });
            t.start();
        }
        Thread.sleep(10_000);

    }
}
