package ua.artcode.ClassWork.Week_5.SimpleEbay.validation;

import ua.artcode.ClassWork.Week_5.SimpleEbay.exception.ValidationException;

/**
 * Created by serhii on 15.08.15.
 */
public interface Validator<T> {


    boolean isValid(T entity) throws ValidationException;

}
