package com.date.database.service;

import com.date.database.dto.MessageLogDto;
import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaveMessageService {

    @Autowired
    MessageLogRepository messageLogRepository;

    public void saveMessage(MessageLogDto messageLogDto){
        String dateTime = LocalDateTime.now().toString();

        MessageLog messageLog = new MessageLog();
        messageLog.setDateAtTime(dateTime);
        messageLog.setRead(Boolean.FALSE);
        messageLog.setMessage(messageLogDto.getMessage());
        messageLogRepository.save(messageLog);
        System.out.println(messageLog.getDateAtTime() + " salva");
    }
}
