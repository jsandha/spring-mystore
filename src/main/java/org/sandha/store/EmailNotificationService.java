package org.sandha.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService{
    @Value("${mail.host}")
    private String mailServer;

    @Value("${mail.port}")
    private int port;

    @Override
    public void send(String message) {
         System.out.println("Email");
         System.out.println("Message " + message);
    }
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Message " + message);
        System.out.println("RecipientEmail " + recipientEmail);
        System.out.println("MailServer " + mailServer);
        System.out.println("Port " + port);
    }
}
