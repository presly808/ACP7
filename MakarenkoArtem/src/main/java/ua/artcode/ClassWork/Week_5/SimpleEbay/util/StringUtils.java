package ua.artcode.ClassWork.Week_5.SimpleEbay.util;

import java.util.UUID;

/**
 * Created by serhii on 15.08.15.
 */
public final class StringUtils {


    private StringUtils(){}


    public static String generateRandomToken(int length){
        return UUID.randomUUID().toString().substring(length);
    }
}
