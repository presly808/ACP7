package ua.artcode.week2.console_menu;

/**
 * Created by Daryna on 13-Jul-15.
 */
public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String message){
        super(message);
    }
}
