package com.kodilla.exception.nullpointer;

public class MessageSender {

    public void sendMessageTo(User user, String message) throws MessageNotSentException {
        if (user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        } else {
            throw new MessageNotSentException("Object User was null");
        }
    }
}

class MessageNotSentException extends Exception {

    public MessageNotSentException(final String message) {
        super(message);
    }
}

class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send," +
                    "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }
}
