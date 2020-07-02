package com.unisys.jms.client;

import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SendMessage {

	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		
		Context jndiContext = new InitialContext(props);
		
		// 1. Destination
		Queue queue = (Queue) jndiContext.lookup("jms/queue/TestQueue");
		
		// 2. ConnectionFactory
		ConnectionFactory cf = (ConnectionFactory) jndiContext.lookup("jms/RemoteConnectionFactory");
		
		// ConnectionFactory -> Connection -> Session -> MessageProducer/MessageConsumeer/Message
		Connection conn = cf.createConnection("vinodkumar", "Welcome#123");
		Session session = conn.createSession();
		
		MessageProducer producer = session.createProducer(queue); // producer is aware of message's destination
		TextMessage tm = session.createTextMessage("Hello, consumer! my clock says: " + new Date());
		
		producer.send(tm);
		System.out.println("Message has been sent to the destination");
		
		conn.close(); // closes session also
		
	}

}
