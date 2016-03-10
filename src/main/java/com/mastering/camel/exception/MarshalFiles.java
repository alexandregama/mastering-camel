package com.mastering.camel.exception;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MarshalFiles {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() {
				from("file:entry?delay=3s").
					log(LoggingLevel.INFO, "Processing the message: ${id}").
					unmarshal().xstream().
					marshal().serialization().
				to("file:marshal");	
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
	}
	
}
