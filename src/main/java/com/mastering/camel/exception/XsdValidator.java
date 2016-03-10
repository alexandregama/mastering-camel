package com.mastering.camel.exception;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class XsdValidator {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			
			@Override
			public void configure() {
				errorHandler(
					deadLetterChannel("file:exception").
						useOriginalMessage().
							maximumRedeliveries(4).
								redeliveryDelay(2_000).
									retryAttemptedLogLevel(LoggingLevel.INFO)
				);
				
				from("file:entry?delay=5s").
					log(LoggingLevel.INFO, "Processing the message: {id}").
				to("validator:file:xsd/pedido.xsd").
				to("file:exit");	
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
	}
	
}
