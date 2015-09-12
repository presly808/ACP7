package ua.artcode.week10.soap.endpoint;


import ua.artcode.week10.soap.model.Car;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServiceEndpoint {

    @WebMethod
    Car findById(int id);

}
