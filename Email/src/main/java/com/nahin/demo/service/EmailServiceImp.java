package com.nahin.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nahin.demo.model.Email;
import com.nahin.demo.model.EmailUser;
import com.nahin.demo.repository.EmailRepo;
import com.nahin.demo.repository.EmailUserRepo;


@Component
public class EmailServiceImp implements EmailService {
	@Autowired
	private EmailUserRepo erepo;
	
	@Autowired EmailRepo mailrepo;
	
	@Override
	public EmailUser reg(EmailUser user) {
		return erepo.save(user);
	}
	public EmailUser login(String ename, String pass) {
		EmailUser find=erepo.findByName(ename, pass);
		System.out.println(find);
		return find;		
	}
		@Override
	public EmailUser sendemail(String to) {	
		EmailUser findBy = erepo.findBy(to);
		return findBy;
	}
		@Autowired
		private EmailRepo emailrepo;
		@Override
		public void receive(Email mail) {
			emailrepo.save(mail);	
			
		}
		@Override
		public List<Email> checkmail(String to) {
			List<Email> findByTo = mailrepo.findByTo(to);
			return findByTo;
		}
		@Override
		public List<Email> checkSender(String from) {
			List<Email> findByFrom = mailrepo.findByFrom(from);
			return findByFrom;
		}
}
