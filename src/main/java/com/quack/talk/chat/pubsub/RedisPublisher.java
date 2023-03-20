package com.quack.talk.chat.pubsub;

import com.quack.talk.common.chat.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(String roomId, MessageDTO message){
        redisTemplate.convertAndSend(roomId, message);
    }
}
