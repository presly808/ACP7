package exeption;

import java.io.IOException;

/**
 * Created by root on 05.09.15.
 */
public class WrongUserCredentionalException extends Exception {
    public WrongUserCredentionalException(String message) {
        super(message);
    }
}
