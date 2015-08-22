package week4.homeWorkWeek4.myChat.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Пользователь on 24.07.15.
 */
public class MessageMy {
    private String sender;
    private String recipient;
    private String messegeBody;
    private Date date;
    private Time time;


    public MessageMy() {

    }

    public MessageMy(String sender, String recipient, String messegeBody, Date date, Time time) {
        this.sender = sender;
        this.recipient = recipient;
        this.messegeBody = messegeBody;
        this.date = date;
        this.time = time;
    }

    public MessageMy build() {
        return new MessageMy(sender, recipient, messegeBody, date, time);
    }

    public MessageMy appendSender(String sender) {
        this.sender = sender;
        return this;
    }

    public MessageMy appendRecipient(String recipient) {
        this.recipient = recipient;
        return this;

    }

    public MessageMy appendMessageBody(String messegeBody) {
        this.messegeBody = messegeBody;
        return this;
    }

    public MessageMy appendDate(Date date) {
        this.date = date;
        return this;
    }

    public MessageMy appendTime(Time time) {
        this.time = time;
        return this;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessegeBody() {
        return messegeBody;
    }

    public void setMessegeBody(String messegeBody) {
        this.messegeBody = messegeBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Message{" +
                "From:'" + sender + '\n' +
                ", To:='" + recipient + '\n' +
                ", messege body:'" + messegeBody + '\n' +
                ", date= " + date +
                ", time= " + time +
                '}';
    }
}
