package it1sso2503is.springlab01.notify;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("upper")
@Order(3)
public class UpperNotifier implements Notifier {

    private static final Logger log =
            LoggerFactory.getLogger(UpperNotifier.class);

    @PostConstruct
    void init() {
        log.info("UPPER NOTIFIER >> initialized");
    }

    @Override
    public String send(String message) {
        return message.toUpperCase();
    }

    @Override
    public String channel() {
        return "upper";
    }
}