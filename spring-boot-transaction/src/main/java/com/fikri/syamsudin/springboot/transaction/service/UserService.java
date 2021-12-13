package com.fikri.syamsudin.springboot.transaction.service;

import com.fikri.syamsudin.springboot.transaction.entity.User;
import com.fikri.syamsudin.springboot.transaction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void create(User user){
        userRepository.save(user);
    }
}
