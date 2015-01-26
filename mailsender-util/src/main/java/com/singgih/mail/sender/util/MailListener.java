package com.singgih.mail.sender.util;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

public class MailListener {
	public void listen() throws MessagingException {
		String host = "10.21.144.250";
		String user = "singgih";
		String password = "rahasia";

		// connect to my pop3 inbox
		Properties properties = System.getProperties();
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3");
		store.connect(host, user, password);
		Folder inbox = store.getFolder("Inbox");

		inbox.open(Folder.READ_ONLY);

		// get the list of inbox messages
		Message messages[] = inbox.search(new FlagTerm(new Flags( Flags.Flag.SEEN), false));
		if (messages.length == 0)
			System.out.println("No messages found.");

		for (int i = 0; i < messages.length; i++) {
			// stop after listing ten messages
			if (i > 10) {
				System.exit(0);
				inbox.close(true);
				store.close();
			}
			messages[i].setFlag(Flag.SEEN, true);
			System.out.println("Message " + (i + 1));
			System.out.println("From : " + messages[i].getFrom()[0]);
			System.out.println("Subject : " + messages[i].getSubject());
			System.out.println("Sent Date : " + messages[i].getSentDate());
			System.out.println("Sent Date : " + messages[i].getSentDate());

			System.out.println();
		}

		inbox.close(true);
		store.close();
	}
}
