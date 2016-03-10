package com.mastering.camel.transform;

import org.apache.camel.Exchange;

public class TransformerBean {

	public void transform(Exchange exchange) {
		System.out.println("Message Id: " + exchange.getIn());
		System.out.println("Message Content: " + exchange.getIn().getBody(String.class));
	}
}
