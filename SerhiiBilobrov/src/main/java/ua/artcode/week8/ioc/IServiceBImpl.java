package ua.artcode.week8.ioc;

import java.util.Date;

/**
 * Created by serhii on 29.08.15.
 */
public class IServiceBImpl implements IService {
    @Override
    public String format(Date date) {
        return date.toString();
    }
}
