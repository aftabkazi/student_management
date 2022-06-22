package com.studentmanagement.studentmanagement.response;

public class GlobalResponse {
	
	private Boolean status;
	private String message;
	
	public GlobalResponse() {
		super();
	}

	public GlobalResponse(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
