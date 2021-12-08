package com.github.durakin;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "apparel-queue", containerFactory =
            "rabbitListenerContainerFactory")

    public void listen(Message message) {
        System.out.println('\n' + message.getAction() + "\nOn apparel\n" + message.getApparel().toString() + "On time\n" + message.getTime());
    }
}
