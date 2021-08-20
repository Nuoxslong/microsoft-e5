package cn.codegraffiti.microsofte5.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageMq {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("randomQueue"),
            exchange = @Exchange("randomExChange")
    ))
    public void process3(String message){
        log.info("randomQueue: {}", message);
    }
}
