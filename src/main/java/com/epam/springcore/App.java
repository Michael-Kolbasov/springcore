package com.epam.springcore;

import com.epam.springcore.enums.EventType;
import com.epam.springcore.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean(App.class);
        app.logEvent(context.getBean(Event.class), null);
        app.logEvent(context.getBean(Event.class), EventType.INFO);
        app.logEvent(context.getBean(Event.class), EventType.ERROR);

        context.close();
    }

    private void logEvent(Event event, EventType eventType) {
        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        event.setMessage(client.getGreeting() + client.getFullName() + "!");
        logger.logEvent(event);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDefaultLogger(EventLogger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }

    public void setLoggers(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }
}
