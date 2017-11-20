package com.framework.utils;

import com.aventstack.extentreports.Status;

public class Message {

	Status status;
	String message;
	boolean isSnap;
	public Message(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.isSnap = false;
	}
	public Message(Status status, String message, boolean isSnap) {
		super();
		this.status = status;
		this.message = message;
		this.isSnap = isSnap;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSnap() {
		return isSnap;
	}
	public void setSnap(boolean isSnap) {
		this.isSnap = isSnap;
	}
}
