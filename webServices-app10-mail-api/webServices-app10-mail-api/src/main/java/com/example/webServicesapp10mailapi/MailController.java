package com.example.webServicesapp10mailapi;

import java.io.IOException;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("mail1")
	public String mail1() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("rrpptwr2795@gmail.com");
//	    msg.setCc("a@a.com");
//	    msg.setBcc("a@a.com");
	    msg.setSubject("Testing from Spring Boot");
	    msg.setText("Hello World \n Spring Boot Email"); //sending as a plain text
	    javaMailSender.send(msg);		
		return "success";
	}
	
	
	@GetMapping("/mail2")
	public String mail2() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        helper.setTo("rrpptwr2795@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Hello from spring boot app</h1>");
        // default = text/plain
         javaMailSender.send(msg);
        return "success";
    }	
	
	// mail with HTML body
	@GetMapping("/mail3")
	public String mail3() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("rrpptwr2795@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Hello from spring boot app</h1>", true);
        // true = text/html
         javaMailSender.send(msg);
        return "success";
    }	
	
	
	
	// mail with attachment
	
	@GetMapping("/mail4")
	public String mail4() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("rrpptwr2795@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Pls find an attachment</h1>", true);
        // default = text/plain
        // true = text/html
        helper.addAttachment("myappconfig.properties", 
        					new ClassPathResource("application.properties"));   // attaching application.properties
        //specified file should be in the resourses folder
        javaMailSender.send(msg);
        return "success";
    }	
	
}
