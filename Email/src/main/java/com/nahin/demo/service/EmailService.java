package com.nahin.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nahin.demo.model.Email;
import com.nahin.demo.model.EmailUser;

@Service
public interface EmailService {

	EmailUser reg(EmailUser user);

	EmailUser login(String ename, String pass);

	EmailUser sendemail(String to);

	void receive(Email mail);
	
	List<Email> checkmail(String to);

	List<Email> checkSender(String from);

}
