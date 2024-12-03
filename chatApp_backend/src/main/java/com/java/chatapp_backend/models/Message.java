package com.java.chatapp_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message
{
    private String sender;
    private String message;
    private LocalDateTime timeStamp;

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
