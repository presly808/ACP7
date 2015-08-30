package exception;

/**
 * Created by serhii on 15.08.15.
 */
public class WrongUserCredentialException extends Exception {

    public WrongUserCredentialException(String message) {
        super(message);
    }

}
