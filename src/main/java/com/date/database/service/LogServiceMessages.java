package com.date.database.service;

import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceMessages {

    @Autowired
    MessageLogRepository messageLogRepository;

    @Scheduled(fixedDelay = 1000)
    public void logTheMessages(){
        System.out.println("Iniciou thread");
        List<MessageLog> byIsReadIsFalse = messageLogRepository.findByIsReadIsFalse();
            byIsReadIsFalse.forEach(this::isFiveSecondsAfter);
    }

    public void isFiveSecondsAfter(MessageLog messageLog) {
        LocalDateTime timeAtReadMessage = LocalDateTime.parse(messageLog.getDateAtTime());
        int diff = LocalDateTime.now().getSecond() - timeAtReadMessage.getSecond();
        if(diff>= 5){
            try{
                Thread.sleep(6000);
            } catch (Exception e){
                System.out.println("teste");
            }
            System.out.println(messageLog);
            messageLog.setRead(Boolean.TRUE);
            messageLogRepository.save(messageLog);
        }
    }
}
