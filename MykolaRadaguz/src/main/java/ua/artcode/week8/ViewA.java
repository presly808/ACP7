package ua.artcode.week8;

import java.util.Date;

/**
 * Created by pikolo on 29.08.15.
 */
public class ViewA {

    @ForInject
    private IService service;

    public ViewA() {


    }

    public ViewA(IService service) {
        this.service = service;
    }

    public IService getService() {
        return service;
    }

    public void setService(IService service) {
        this.service = service;
    }

    public void useService(){
        System.out.println(service.format(new Date()));
    }
}
