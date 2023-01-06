package com.date.database.kafka;

import com.date.database.dto.MessageLogDto;
import com.date.database.service.SaveMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class KafkaConsumerTest {

    @Mock
    SaveMessageService saveMessageService;

    @InjectMocks
    KafkaConsumer kafkaConsumer;

    @Test
    public void consumer(){
        String message = "Teste mensagem recebida por param";
        this.kafkaConsumer.consumer(message);

        verify(this.saveMessageService, times(1)).saveMessage(any(MessageLogDto.class));
    }

}