package ua.artcode.week8;

import java.util.Date;

/**
 * Created by pikolo on 29.08.15.
 */
public class IServiceBImpl implements IService{

    @Override
    public String format(Date date) {
        return date.toString();
    }

}
