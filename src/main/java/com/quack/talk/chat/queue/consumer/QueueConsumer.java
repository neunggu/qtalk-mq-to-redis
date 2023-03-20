package com.quack.talk.chat.queue.consumer;

import com.quack.talk.chat.service.ChatService;
import com.quack.talk.common.chat.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class QueueConsumer {

    private final ChatService chatService;

    @RabbitListener(queues ="chat.message.queue")
    public void receiveMessage(final MessageDTO message){
        chatService.sendChatMessage(message);
    }
}
