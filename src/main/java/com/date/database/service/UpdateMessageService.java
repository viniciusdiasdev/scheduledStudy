package com.date.database.service;

import com.date.database.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMessageService {

    @Autowired
    MessageLogRepository messageLogRepository;

}
