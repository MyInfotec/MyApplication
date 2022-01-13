package com.MyApplication.myApp.entity;

public class Response {

	private String data;
	private String message;

	public Response(String message) {
		super();
		this.message = message;
	}

	public Response(String data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
