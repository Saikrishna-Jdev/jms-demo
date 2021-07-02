package com.sai.webapp.jmsdemo.sender;

import com.sai.webapp.jmsdemo.config.JmsConfig;
import com.sai.webapp.jmsdemo.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor

@Component
public class HelloSender {

    public final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        HelloWorldMessage message=HelloWorldMessage
                                    .builder()
                                    .id(UUID.randomUUID())
                                    .message("HelloWorld").build();
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,message);
        System.out.println("Message sent");
    }

}
