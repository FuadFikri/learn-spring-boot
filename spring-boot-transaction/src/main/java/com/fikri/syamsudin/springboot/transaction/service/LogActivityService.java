package com.fikri.syamsudin.springboot.transaction.service;


import com.fikri.syamsudin.springboot.transaction.entity.LogActivity;
import com.fikri.syamsudin.springboot.transaction.repository.LogActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogActivityService {


    private final LogActivityRepository logActivityRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String feature, String message) {
        LogActivity logActivity = LogActivity.builder()
                .feature(feature)
                .message(message)
                .time(LocalDateTime.now())
                .build();

        logActivityRepository.save(logActivity);

    }
}
