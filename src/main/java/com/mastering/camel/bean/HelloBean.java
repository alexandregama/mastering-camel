package com.mastering.camel.bean;

public class HelloBean {

	public String hello(String message) {
		String helloMessage = "Hello " + message;
		
		System.out.println(helloMessage);
		
		return helloMessage;
	}
}
