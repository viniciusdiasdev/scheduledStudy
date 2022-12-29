package com.date.database.service;

import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMessageService {

    @Autowired
    MessageLogRepository messageLogRepository;

    public void updateMessage(MessageLog messageLog){
        System.out.println(messageLog);
        messageLog.setRead(Boolean.TRUE);
        messageLogRepository.save(messageLog);
    }
}
