package com.example.webServicesapp11emailverify;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("signup")
	public String save(@RequestBody Person person) throws MessagingException, IOException {		
		person.setStatus(0);
		String token = UUID.randomUUID().toString();
		person.setToken(token);
		personRepository.save(person);		
	    MimeMessage msg = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	    helper.setTo(person.getUsername());
	    helper.setSubject("Verfify your email");
	    String url = "http://localhost:9092/verifyEmail/" + person.getUsername() + "/" + token;
	    helper.setText("<h1><a href='" + url + "'> Verfify your email </a></h1>", true);
        javaMailSender.send(msg);		
        return "saved successfully. We have sent a mail to your email inbox. " +
        		"Please verify your email by goining into email inbox";
	}
	
	@GetMapping("verifyEmail/{email}/{token}")
	public String verifyEmail(@PathVariable String email, @PathVariable String token) {
		Person person = personRepository.findByUsername(email);
		String status = "failure";
		if(person.getToken().equals(token)) {
			status = "Verified successfully";
			person.setStatus(1);
			personRepository.save(person);
		}
		return status;
	}
	
}

// develop 2 api
// one is for receiving customer data storing in the data base and sending to the email whichever is specified 
// receiving a message from mail box // request move to the second api // in the second api we will be compiling one token if the token is proper then it will be updating in the db

