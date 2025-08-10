package org.sandha.store.movedCode;

public interface NotificationService {
    void send(String message);
    void send(String message, String recipientEmail);
}
