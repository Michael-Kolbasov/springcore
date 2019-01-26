package com.epam.springcore.loggers;

import com.epam.springcore.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }

    public void setLoggers(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }
}
