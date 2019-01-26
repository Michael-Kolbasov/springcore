package com.epam.springcore.loggers;

import com.epam.springcore.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void logEvent(Event event) {
        File file = new File(fileName);
        try {
            FileUtils.writeStringToFile(file, event.toString(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException("Can't write to file: " + fileName);
        }
    }
}
