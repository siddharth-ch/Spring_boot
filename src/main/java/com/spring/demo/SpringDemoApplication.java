package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringDemoApplication {

    public static void main(String[] args) {
	ApplicationContext app = SpringApplication.run(SpringDemoApplication.class, args);
	MessageServiceImpl impl = app.getBean(MessageServiceImpl.class);
	impl.send("Sending message");
    }
}
