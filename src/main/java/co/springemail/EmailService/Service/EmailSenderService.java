package co.springemail.EmailService.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import co.springemail.EmailService.Domain.User;
import co.springemail.EmailService.Repository.UserRepository;

@Service
public class EmailSenderService {

	private final Logger log = LoggerFactory.getLogger(EmailSenderService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserRepository userRepository;
	
	public void sendMailToHr() {
		//Getting respective list from userRepo ---->
		List<User> hrList = userRepository.findByUserRoleAndUserStatus("HR",1);
		List<User> activeUser = userRepository.findByUserStatus(1);
		
		//New Lists of employees having bday in few days ---> 
		List<String> birthdayUserNameList = new ArrayList<>();
		List<LocalDate> birthdayUserDobList = new ArrayList<>();
		List<String> employeeIdList = new ArrayList<>();
		
		//List of Employees whose DOB is missing -->
		List<String> missingDobList = new ArrayList<>();
		
		LocalDate date = LocalDate.now();
		
		for(User user : activeUser) {
			LocalDate userDob = user.getDob();
			
			if(userDob != null) {
		//.withYear(2023) need to change every year --->
				LocalDate userDob2 = userDob.withYear(2023);
				LocalDate userBirthdayCelebration = date.plusDays(2);
				
				Period difference = Period.between(userBirthdayCelebration, userDob2);
				if((difference.getDays() == 2) ||(difference.getDays() == 1)||(difference.getDays() == 0)|| (difference.getDays() == -1) || (difference.getDays() == -2)) {
					
					if(difference.getMonths()==0) {
						birthdayUserNameList.add(user.getUserName());
						birthdayUserDobList.add(userDob2);
						employeeIdList.add(user.getLoginId());
					}else {
						continue;
					}
				}else {
					continue;
				}	
			}else {
				log.warn(" DOB is missing " + user.getUserName());
				continue;
			}
		}
		
		//To see in Console using Logger --->
		log.info("birthdayUSerNameList is {}",birthdayUserNameList);
		log.info("birthdayUserDobList is {}",birthdayUserDobList);
		log.info("EmployeeIdList is {}",employeeIdList);
		log.info("MissingDobList is {}",missingDobList);
		
		//Content to sent in Mail --->
		
		for(User user : hrList) {
			sendSimpleEmail(" Good Morning !! Have a Great Day . \n \n This is the Birthday Reminder Mail \n\n Following Employees are having Birthdays on the upcoming days : "+ birthdayUserNameList + "\n \n Respective Dates are : "+birthdayUserDobList +"\n\n Respective EmployeeId are : "+ employeeIdList+ " \n \n \n ### Following employee's DOB are missing : " +missingDobList,"(BIRTHDAY REMINDER MAIL) !!!.. ",user.getOfficialEmail());	
		}	
	}
	
	private void sendSimpleEmail(String body , String subject , String toEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("saxenaayu2106@gmail.com");
		message.setTo(toEmail);
		message.setCc("abhishek.sinha2021@vitbhopal.ac.in");
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Email has been Sent !.....");
	}
}
