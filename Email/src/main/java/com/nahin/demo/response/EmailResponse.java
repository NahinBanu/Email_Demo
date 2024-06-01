package com.nahin.demo.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nahin.demo.model.Email;

@Component
public class EmailResponse {
	private boolean error;
	private String message;
	private List<Email>email;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Email> getEmail() {
		return email;
	}
	public void setEmail(List<Email> email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailResponse [error=" + error + ", message=" + message + ", email=" + email + "]";
	}
	

}
