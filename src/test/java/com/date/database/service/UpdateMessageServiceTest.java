package com.date.database.service;

import com.date.database.entity.MessageLog;
import com.date.database.repository.MessageLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateMessageServiceTest {

    @Mock
    MessageLogRepository messageLogRepository;

    @InjectMocks
    UpdateMessageService updateMessageService;


    @Test
    public void updateMessage(){
        MessageLog messageLog = new MessageLog();
        messageLog.setMessage("Teste mensagem");
        messageLog.setRead(Boolean.FALSE);
        MessageLog messageLogReturn = new MessageLog();

        when(messageLogRepository.save(messageLog)).thenReturn(messageLogReturn);
        this.updateMessageService.updateMessage(messageLog);

        assertEquals(messageLog.getRead(), Boolean.TRUE);
    }

}