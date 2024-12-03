package com.java.chatapp_backend.controllers;

import com.java.chatapp_backend.Services.RoomService;
import com.java.chatapp_backend.dtos.MessageRequestDTO;
import com.java.chatapp_backend.models.Message;
import com.java.chatapp_backend.models.Room;
import com.java.chatapp_backend.repos.RoomRepo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController
{
    private RoomRepo roomRepo;
    public ChatController(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @RequestBody MessageRequestDTO messageRequestDTO,
            @DestinationVariable String roomId
    )
    {
        Optional<Room> room = roomRepo.findById(messageRequestDTO.getRoomId());
        if(room.isEmpty())
            return new Message("Room not found", roomId);
        Room chatRoom = room.get();
        Message message = new Message();
        message.setMessage(messageRequestDTO.getMessage());
        message.setSender(messageRequestDTO.getSender());
        message.setTimeStamp(LocalDateTime.now());

        chatRoom.getMessages().add(message);
        roomRepo.save(chatRoom);
        return message;
    }
}
