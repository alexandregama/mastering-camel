package com.mastering.camel.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TransformAndAppendStringBody {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() {
				from("file:entry?delay=3s").
					log(LoggingLevel.INFO, "Processing the following message: ${id}").
					transform(bodyAs(String.class).regexReplaceAll("autor", "nameAuthor")).
					setBody(body().append("From day: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()))).
				to("file:exit");	
			}
		});
			
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
		
		System.out.println("Camel has been stoped!");
	}
	
}
