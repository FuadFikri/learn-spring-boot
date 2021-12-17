package com.fikri.syamsudin.databaselocking;

import com.fikri.syamsudin.databaselocking.entity.OrderNumber;
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
    public void getNumberTest(){
        Long result = orderNumberService.getNumber("21L00");
        Assertions.assertNotNull(result);
        System.out.println("order number result = "+ result);
    }
}
