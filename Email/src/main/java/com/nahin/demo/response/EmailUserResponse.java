package com.nahin.demo.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nahin.demo.model.EmailUser;

@Component
public class EmailUserResponse {
	private Boolean error;
	private String msg;
	private List<EmailUser>emailResp;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<EmailUser> getEmailResp() {
		return emailResp;
	}
	public void setEmailResp(List<EmailUser> emailResp) {
		this.emailResp = emailResp;
	}
	
}
	