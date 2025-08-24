package org.sandha.store.movedCode;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
         System.out.println("SMS");
         System.out.println("Message " + message);
    }
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Message " + message);
        System.out.println("RecipientEmail " + recipientEmail);
    }
}
