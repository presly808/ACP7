package week4.homeWorkWeek4.myChat.controller;

import week4.homeWorkWeek4.myChat.model.MessageMy;


public interface IOHelper {

    void save(String path, MessageMy messageMy);

    MessageMy load(String path);

}
