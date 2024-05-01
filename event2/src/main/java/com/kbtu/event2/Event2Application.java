package com.kbtu.event2;

import com.kbtu.event2.service.SpringBuiltInEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Event2Application {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Event2Application.class);
		springApplication.addListeners(new SpringBuiltInEventListener());
		springApplication.run(args);

	}

}
