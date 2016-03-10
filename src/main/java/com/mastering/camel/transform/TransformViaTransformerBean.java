package com.mastering.camel.transform;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TransformViaTransformerBean {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
		
			@Override
			public void configure() {
				from("file:entry?delay=3s").
					log(LoggingLevel.INFO, "Processing message: ${id}").
					transform(bodyAs(String.class).regexReplaceAll("autor", "nameAuthor")).
					bean(TransformerBean.class, "transform").
				to("file:exit");	
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
		
		System.out.println("Camel has been stoped!");
	}
}
