package cn.codegraffiti.microsofte5.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMessageMq {

    final AmqpTemplate amqpTemplate;

    public void sendRandomQueue() {
        amqpTemplate.convertAndSend("randomQueue", "e5");
    }
}
