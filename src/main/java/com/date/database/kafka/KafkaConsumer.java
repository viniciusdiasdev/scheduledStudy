package com.date.database.kafka;

import com.date.database.dto.MessageLogDto;
import com.date.database.service.SaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class KafkaConsumer {

    @Autowired
    SaveMessageService saveMessageService;

    @KafkaListener(topics = "vinicius3_client", groupId = "client-groupId")
    public void consumer(String message){
        MessageLogDto messageLogDto = new MessageLogDto(message);
        saveMessageService.saveMessage(messageLogDto);
    }
}
