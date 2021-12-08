package com.github.durakin.isdlabs.lab7.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String action;
    private LocalDateTime time;
    private Apparel apparel;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Apparel getApparel() {
        return apparel;
    }

    public void setApparel(Apparel apparel) {
        this.apparel = apparel;
    }

    public Message() {
    }

    public Message(String action, LocalDateTime time, Apparel apparel) {
        this.action = action;
        this.time = time;
        this.apparel = apparel;
    }
}
