package com.epam.springcore;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Event {
    private Integer id;
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public static boolean isDay() {
        LocalTime now = LocalTime.now();
        LocalTime pm5 = LocalTime.of(17, 0);
        LocalTime am8 = LocalTime.of(8, 0);
        return now.isAfter(am8) && now.isBefore(pm5);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    @Autowired(required = false)
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
