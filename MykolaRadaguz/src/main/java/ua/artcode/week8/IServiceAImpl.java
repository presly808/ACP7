package ua.artcode.week8;

import java.util.Date;

/**
 * Created by pikolo on 29.08.15.
 */
public class IServiceAImpl implements IService {
    @Override
    public String format(Date date) {
        return String.format("%1$tY-%1$tm-%1$td", date);
    }
}
