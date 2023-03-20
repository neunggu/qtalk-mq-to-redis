package com.quack.talk.chat.service;

import com.quack.talk.chat.pubsub.RedisPublisher;
import com.quack.talk.common.chat.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final RedisPublisher redisPublisher;

    public MessageDTO sendChatMessage(MessageDTO chatMessage){
        redisPublisher.publish(chatMessage.getRoomId(), chatMessage);
        return chatMessage;
    }

}
