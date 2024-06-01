package com.nahin.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nahin.demo.model.Email;
import com.nahin.demo.model.EmailUser;
import com.nahin.demo.response.EmailResponse;
import com.nahin.demo.response.EmailUserResponse;
import com.nahin.demo.service.EmailService;

@RestController
public class MyController {
	@Autowired
	private EmailService service;

	@Autowired
	private EmailUserResponse response;
	
	@Autowired
	private EmailResponse eresponse;

	@PostMapping("/Register")
	public ResponseEntity<EmailUserResponse> reg(@RequestBody EmailUser user) {
		EmailUser Dto = service.reg(user);
		if (Dto != null) {
			response.setError(false);
			response.setMsg("data add successful");
			response.setEmailResp(Arrays.asList(Dto));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("falied to add");
			response.setEmailResp(Arrays.asList(Dto));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<EmailUserResponse> login(@RequestBody EmailUser user) {
		EmailUser Dto1 = service.login(user.getEname(), user.getPass());
		if (Dto1 != null) {
			response.setError(false);
			response.setMsg("login successfull");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("falied to login");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	@PostMapping("/sendmail")
	public ResponseEntity<EmailUserResponse> mail(@RequestBody Email mail) {
		
		EmailUser Dto2 = service.sendemail(mail.getTo());
		if (Dto2 != null) {
			service.receive(mail);
		}
		if (Dto2 != null) {
			response.setError(false);
			response.setMsg("Email send");
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("falied to send the mail");
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
	}
		@GetMapping("/inbox")
		public ResponseEntity<EmailResponse> inbox(@RequestBody Email mail) {
			List<Email>list = service.checkmail(mail.getTo());
			
			if (list != null) {
				eresponse.setError(false);
				eresponse.setMessage("Your Inbox");
				eresponse.setEmail((list));
				return new ResponseEntity<EmailResponse>(eresponse, HttpStatus.OK);
			} else {
				eresponse.setError(true);
				eresponse.setMessage("no mails");
				eresponse.setEmail(list);
				return new ResponseEntity<EmailResponse>(eresponse, HttpStatus.OK);

			}		
		}
		
		@GetMapping("/sent")
		public ResponseEntity<EmailResponse> sent(@RequestBody Email mail) {
			List<Email>sender = service.checkSender(mail.getFrom());
			
			if (sender != null) {
				eresponse.setError(false);
				eresponse.setMessage("Your sent msg");
				eresponse.setEmail((sender));
				return new ResponseEntity<EmailResponse>(eresponse, HttpStatus.OK);
			} else {
				eresponse.setError(true);
				eresponse.setMessage("no mails");
				eresponse.setEmail(sender);
				return new ResponseEntity<EmailResponse>(eresponse, HttpStatus.OK);

			}		
		}
		
	
}