package com.spring.exception;

public class PlayerExceptionResponse {

	private String message;
	private int statusCode;
	private long timeStamp;

	public String getMessage() {
		return message;
	}

	public PlayerExceptionResponse(String message, int statusCode, long timeStamp) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

	public PlayerExceptionResponse(String string) {
		message = string;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
