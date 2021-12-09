package com.github.durakin.model;

import java.io.Serializable;

public class Message implements Serializable {
    private String action;
    private String time;
    private Apparel apparel;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public Message(String action, String time, Apparel apparel) {
        this.action = action;
        this.time = time;
        this.apparel = apparel;
    }
}
