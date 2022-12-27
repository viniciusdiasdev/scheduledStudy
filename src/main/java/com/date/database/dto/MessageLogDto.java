package com.date.database.dto;

import java.util.Date;

public class MessageLogDto {

    private String message;

    private Date dateAtMoment;

    public MessageLogDto(String message, Date dateAtMoment) {
        this.message = message;
        this.dateAtMoment = dateAtMoment;
    }

    public MessageLogDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateAtMoment() {
        return dateAtMoment;
    }

    public void setDateAtMoment(Date dateAtMoment) {
        this.dateAtMoment = dateAtMoment;
    }
}
