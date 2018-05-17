package com.spring.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {

    String message;

    @JmsListener(destination = "simple.queue")
    public void onMessage(String message) {
	System.out.println("Helllo..........." + message);
	this.message = message;
    }

    public String receive() {
	return message;
    }
}
