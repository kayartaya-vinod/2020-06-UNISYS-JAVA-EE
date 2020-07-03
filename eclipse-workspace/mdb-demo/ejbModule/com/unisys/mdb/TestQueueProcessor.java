package com.unisys.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/TestQueue")
})
public class TestQueueProcessor implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		
		if(msg instanceof TextMessage) {
			TextMessage tm = (TextMessage) msg;
			try {
				System.out.println("Got this message from a client: " + tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
	}

}
