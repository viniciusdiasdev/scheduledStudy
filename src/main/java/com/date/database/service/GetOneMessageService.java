package com.date.database.service;

import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOneMessageService {

    @Autowired
    MessageLogRepository messageLogRepository;

    public MessageLog getOneMessage(){
        List<MessageLog> byIsReadIsFalse = messageLogRepository.findByIsReadIsFalse();
        return byIsReadIsFalse.get(0);
    }
}
