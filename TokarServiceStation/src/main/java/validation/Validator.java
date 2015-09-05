package validation;

import javax.xml.bind.ValidationException;

public interface Validator<T> {

    boolean isValid(T entity) throws ValidationException;
}
