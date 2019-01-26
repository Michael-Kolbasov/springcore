package com.epam.springcore.loggers;

import com.epam.springcore.Event;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private Integer cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, Integer cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }
}
