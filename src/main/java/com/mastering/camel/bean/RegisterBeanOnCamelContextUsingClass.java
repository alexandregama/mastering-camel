package com.mastering.camel.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RegisterBeanOnCamelContextUsingClass {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("direct:start").
				bean(HelloBean.class).
				to("mock:stop");
			}
		});
		
		context.start();
		
		ProducerTemplate producer = context.createProducerTemplate();
		producer.sendBody("direct:start", "Gama!");
		
		context.stop();
	}
}
