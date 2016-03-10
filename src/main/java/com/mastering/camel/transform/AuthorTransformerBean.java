package com.mastering.camel.transform;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public class AuthorTransformerBean {

	public void transform(Exchange exchange) {
		Message message = exchange.getIn();
		System.out.println("Message: " + message);
		
		String body = message.getBody(String.class);
		System.out.println("Body: " + body);
		
		String newBody = body.replaceAll("nomeAutor", "nameAuthor");
		message.setBody(newBody);
	}
}
