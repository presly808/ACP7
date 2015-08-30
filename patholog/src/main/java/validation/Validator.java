package validation;


import exception.ValidationException;

/**
 * Created by serhii on 15.08.15.
 */
public interface Validator<T> {


    boolean isValid(T entity) throws ValidationException;

}
