package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
    private static final String SIMPLE_QUEUE = "simple.queue";

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageServiceImpl(JmsTemplate jmsTemplate) {
	this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
	jmsTemplate.convertAndSend(SIMPLE_QUEUE, message);
    }
}
