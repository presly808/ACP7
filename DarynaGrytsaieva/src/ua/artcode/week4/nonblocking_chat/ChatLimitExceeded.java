package ua.artcode.week4.nonblocking_chat;

/**
 * Created by dasha on 06.08.15.
 */
public class ChatLimitExceeded extends RuntimeException {
    public ChatLimitExceeded(String message) {
        super(message);
    }
}
