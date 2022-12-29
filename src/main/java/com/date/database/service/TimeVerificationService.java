package com.date.database.service;

import com.date.database.entity.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class TimeVerificationService {

    @Autowired
    UpdateMessageService updateMessageService;

    public void testeTime() {
        try{
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println("teste");
        }
    }
}
