package it1sso2503is.springlab01.notify;

public interface Notifier {

    String send(String message);

    String channel();
}