package com.mastering.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MoveFile {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:entry?delay=5s").
					log(LoggingLevel.INFO, "Processing the message ${id} - ${body}").
				to("file:exit");
			}
		});
		
		context.start();
		
		Thread.sleep(5_000);
		
		context.stop();
		
		System.out.println("Camel has been stoped!");
	}
	
}
