package com.epam.springcore.loggers;

import com.epam.springcore.Event;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
