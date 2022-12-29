package com.date.database.service;

import com.date.database.dto.MessageLogDto;
import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaveMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SaveMessageService.class);

    @Autowired
    MessageLogRepository messageLogRepository;

    public void saveMessage(MessageLogDto messageLogDto){
        String dateTime = LocalDateTime.now().toString();
        MessageLog messageLog = new MessageLog();
        messageLog.setDateAtTime(dateTime);
        messageLog.setRead(Boolean.FALSE);
        messageLog.setMessage(messageLogDto.getMessage());
        messageLogRepository.save(messageLog);
        logger.info(messageLog.getDateAtTime() + " mensagem salva.");
    }
}
