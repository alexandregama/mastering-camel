package com.mastering.camel.polling;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class DatabasePolling {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() {
				from("http://localhost:8080/caelum-books/loja/livros/best-sellers").
					delay(3_000).
					unmarshal().
					json().
					log(LoggingLevel.DEBUG, "Debugging: ${id}").
					process(new Processor() {
						
						@Override
						public void process(Exchange exchange) throws Exception {
							Message message = exchange.getIn();
							
							System.out.println(message.getBody());
						}
					}).
				to("mock:livros");
			}
		});
		
		context.start();
		
		Thread.sleep(3_000);
		
		context.stop();
	}
}
