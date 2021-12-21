package com.fikri.syamsudin.databaselocking.service.impl;

import com.fikri.syamsudin.databaselocking.entity.OrderNumber;
import com.fikri.syamsudin.databaselocking.repository.OrderNumberRepository;
import com.fikri.syamsudin.databaselocking.service.OrderNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderNumberServiceImpl implements OrderNumberService {

    @Autowired
    private OrderNumberRepository orderNumberRepository;


    @Override
    @Transactional
    public Long getNumber(String prefix) {
        Optional<OrderNumber> orderNumberOpt = orderNumberRepository.findByPrefix(prefix);

        if (orderNumberOpt.isEmpty()) {
            OrderNumber orderNumber = new OrderNumber();
            orderNumber.setPrefix(prefix);
            orderNumberOpt = Optional.of(orderNumber);
        }
        return orderNumberOpt.map(orderNumber -> {
            orderNumber.setLastNumber(orderNumber.getLastNumber() + 1);
            return orderNumberRepository.save(orderNumber);
        }).map(OrderNumber::getLastNumber).get();


    }
}
