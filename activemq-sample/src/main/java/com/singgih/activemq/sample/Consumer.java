package com.singgih.activemq.sample;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class Consumer implements ExceptionListener {
	private Logger log = Logger.getLogger("com.singgih.activemq");

	public void receiveMessage() {
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
			Connection connection = connectionFactory.createConnection();
			connection.start();
			connection.setExceptionListener(this);

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("FOO.SAMPLEQUEUE");

			MessageConsumer consumer = session.createConsumer(destination);
			while (true) {
				Message message = consumer.receive(10);
				if (1 == 1) {
					if (message != null && message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						String text = textMessage.getText();
						log.debug("Received: " + text);
					}
					Thread.sleep(100);
				}
				else {
					break;
				}
			}
			consumer.close();
			session.close();
			connection.close();
		} catch (Exception fuckingException) {
			log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		consumer.receiveMessage();
	}

	public void onException(JMSException fuckingException) {
		log.error("Fucking Exception : " + fuckingException.getLocalizedMessage());
		fuckingException.printStackTrace();

	}
}
