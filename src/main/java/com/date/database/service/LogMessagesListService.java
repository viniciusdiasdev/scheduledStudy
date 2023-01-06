package com.date.database.service;

import com.date.database.entity.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class LogMessagesListService {

    @Autowired
    GetListMessagesService getListMessagesService;

    @Autowired
    UpdateMessageService updateMessageService;

    @Scheduled(fixedDelay = 1000)
    public void logTheMessages(){
        List<MessageLog> messageLogList = getListMessagesService.getAllMessages();
        if(Objects.nonNull(messageLogList)){
            messageLogList.forEach(messageLog -> isFiveSecondsAfter(messageLog));
        }
    }

    public void isFiveSecondsAfter(MessageLog messageLog) {
        if(Objects.nonNull(messageLog)){
            LocalDateTime timeAtReadMessage = LocalDateTime.parse(messageLog.getDateAtTime());
            Duration duration = Duration.between(LocalDateTime.now(), timeAtReadMessage);
            long diffInSeconds = duration.getSeconds();
            if(Math.abs(diffInSeconds) >= 5){
                RestTemplate restTemplate = new RestTemplate();
                ArrayList<String> object = restTemplate.getForObject("http://localhost:8081/template", ArrayList.class);
                System.out.println(object);
                updateMessageService.updateMessage(messageLog);
            }
        }
    }
}
