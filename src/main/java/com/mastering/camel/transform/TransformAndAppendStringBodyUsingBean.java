package com.mastering.camel.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TransformAndAppendStringBodyUsingBean {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() {
				String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				
				from("file:entry?delay=3s").
					log(LoggingLevel.INFO, "Processing the following message: ${id}").
					bean(AuthorTransformerBean.class, "transform").
					setBody(body().append("\nTransformed date: " + today)).
				to("file:exit");	
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
	}
}
