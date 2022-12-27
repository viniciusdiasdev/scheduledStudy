package com.date.database.repository;

import com.date.database.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
    List<MessageLog> findByIsReadIsFalse();
}
