package com.sai.webapp.jmsdemo.listener;

import com.sai.webapp.jmsdemo.config.JmsConfig;
import com.sai.webapp.jmsdemo.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage hMessage, @Headers MessageHeaders headers, Message message){
        System.out.println("I Got a Message");
        System.out.println(hMessage);


    }
}
