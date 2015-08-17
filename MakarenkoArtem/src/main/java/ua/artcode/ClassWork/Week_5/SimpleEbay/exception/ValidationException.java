package ua.artcode.ClassWork.Week_5.SimpleEbay.exception;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 15.08.15.
 */
public class ValidationException extends Exception {

    private List<String> messageList = new LinkedList<>();

    public ValidationException(String message) {
        super(message);
    }

    public void addMessage(String mess){
        messageList.add(mess);
    }
}
