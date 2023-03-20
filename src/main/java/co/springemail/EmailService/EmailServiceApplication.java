package co.springemail.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;

import co.springemail.EmailService.Service.EmailSenderService;

@SpringBootApplication
public class EmailServiceApplication {
	
	@Autowired
	public EmailSenderService service;
	
	public void EmailSenderService(EmailSenderService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	@Scheduled(cron = "* 10 12 * * *")
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		service.sendMailToHr();
	}
}
