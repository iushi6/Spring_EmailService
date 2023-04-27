package co.springemail.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;

import co.springemail.Email.Service.*;

@SpringBootApplication
@ComponentScan(basePackages = "co.springemail.Email")
public class EmailApplication {
	
	@Autowired
	public EmailSenderService service;
	
	public void EmailSenderService(EmailSenderService service) {
	this.service = service;}
	
	@Autowired
	public UserService userService;
	
	public void UserService (UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}
	
	@Scheduled(cron = "*/2 * * * *")
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		service.sendMailToHr();
	}
	
	
}
