package com.mastering.camel.polling;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RestEndpointPolling {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				Endpoint endpoint = context.getEndpoint("http://localhost:8080/caelum-books/loja/livros/best-sellers");
				
				PollingConsumer consumer = endpoint.createPollingConsumer();
				Exchange exchange = consumer.receive();
				
				System.out.println("Body message: " + exchange.getIn().getBody());
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
		
		System.out.println("Came has been stoped!");
	}
}
