package com.insure.myteam.error;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	private HttpStatus status;
	@Override
	public String toString() {
		return "ErrorDetails [status=" + status + ", message=" + message + "]";
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;

}
