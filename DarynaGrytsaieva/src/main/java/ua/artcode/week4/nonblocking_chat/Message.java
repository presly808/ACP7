package ua.artcode.week4.nonblocking_chat;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by dasha on 05.08.15.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 3940341617988134707L;
    private String name;
    private String text;
    private Calendar time;

    public Message(String name, String text, Calendar time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + ": " + text;
    }
}
