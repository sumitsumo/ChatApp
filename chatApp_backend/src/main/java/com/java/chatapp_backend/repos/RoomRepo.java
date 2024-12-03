package com.java.chatapp_backend.repos;

import com.java.chatapp_backend.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface RoomRepo extends MongoRepository<Room, String>
{
    Room findByRoomId(String id);
}
