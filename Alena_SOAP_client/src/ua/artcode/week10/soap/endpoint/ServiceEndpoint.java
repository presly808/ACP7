
package ua.artcode.week10.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceEndpoint", targetNamespace = "http://endpoint.soap.week10.artcode.ua/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServiceEndpoint {


    /**
     * 
     * @param arg0
     * @return
     *     returns ua.artcode.week10.soap.endpoint.Car
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://endpoint.soap.week10.artcode.ua/ServiceEndpoint/findByIdRequest", output = "http://endpoint.soap.week10.artcode.ua/ServiceEndpoint/findByIdResponse")
    public Car findById(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

}
