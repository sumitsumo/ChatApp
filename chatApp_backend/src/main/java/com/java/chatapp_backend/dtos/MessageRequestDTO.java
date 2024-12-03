package com.java.chatapp_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO
{
    private String message;
    private String sender;
    private String roomId;

    private LocalDateTime messageTime;
}
