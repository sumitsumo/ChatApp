package com.java.chatapp_backend.Services;

import com.java.chatapp_backend.models.Room;
import com.java.chatapp_backend.repos.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService
{
    @Autowired
    private RoomRepo roomRepo;

    public Room createRoom(String roomId)
    {
        Optional<Room> room = roomRepo.findById(roomId);
        if(room.isPresent())
            return null;
        Room room1 = new Room();
        room1.setId(roomId);
        return roomRepo.save(room1);
//        return room1;
    }

    public Room findRoomByID(String roomId)
    {
        Optional<Room> room = roomRepo.findById(roomId);
        if(room.isPresent())
            return room.get();
        return null;
    }
}
