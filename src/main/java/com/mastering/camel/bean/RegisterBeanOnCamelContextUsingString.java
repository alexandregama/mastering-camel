package com.mastering.camel.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class RegisterBeanOnCamelContextUsingString {

	public static void main(String[] args) throws Exception {
		SimpleRegistry registry = new SimpleRegistry();
		registry.put("helloBean", new HelloBean());
		
		CamelContext context = new DefaultCamelContext(registry);
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("direct:start").
				to("bean:helloBean").
				to("mock:stop");
			}
		});
		
		context.start();
		
		ProducerTemplate producer = context.createProducerTemplate();
		producer.sendBody("direct:start", "Gama");
		
		context.stop();
	}
	
}
