package com.date.database.service;

import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMessageService {

    private static final Logger logger = LoggerFactory.getLogger(UpdateMessageService.class);

    @Autowired
    MessageLogRepository messageLogRepository;

    public void updateMessage(MessageLog messageLog){
        logger.info(messageLog.toString());
        messageLog.setRead(Boolean.TRUE);
        messageLogRepository.save(messageLog);
    }
}
