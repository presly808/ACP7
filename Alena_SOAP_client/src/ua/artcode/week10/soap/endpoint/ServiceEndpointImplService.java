
package ua.artcode.week10.soap.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceEndpointImplService", targetNamespace = "http://endpoint.soap.week10.artcode.ua/", wsdlLocation = "http://192.168.1.45:9999/ws/car?wsdl")
public class ServiceEndpointImplService
    extends Service
{

    private final static URL SERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICEENDPOINTIMPLSERVICE_EXCEPTION;
    private final static QName SERVICEENDPOINTIMPLSERVICE_QNAME = new QName("http://endpoint.soap.week10.artcode.ua/", "ServiceEndpointImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.45:9999/ws/car?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION = url;
        SERVICEENDPOINTIMPLSERVICE_EXCEPTION = e;
    }

    public ServiceEndpointImplService() {
        super(__getWsdlLocation(), SERVICEENDPOINTIMPLSERVICE_QNAME);
    }

    public ServiceEndpointImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICEENDPOINTIMPLSERVICE_QNAME, features);
    }

    public ServiceEndpointImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICEENDPOINTIMPLSERVICE_QNAME);
    }

    public ServiceEndpointImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICEENDPOINTIMPLSERVICE_QNAME, features);
    }

    public ServiceEndpointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceEndpointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceEndpoint
     */
    @WebEndpoint(name = "ServiceEndpointImplPort")
    public ServiceEndpoint getServiceEndpointImplPort() {
        return super.getPort(new QName("http://endpoint.soap.week10.artcode.ua/", "ServiceEndpointImplPort"), ServiceEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceEndpoint
     */
    @WebEndpoint(name = "ServiceEndpointImplPort")
    public ServiceEndpoint getServiceEndpointImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.soap.week10.artcode.ua/", "ServiceEndpointImplPort"), ServiceEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICEENDPOINTIMPLSERVICE_EXCEPTION!= null) {
            throw SERVICEENDPOINTIMPLSERVICE_EXCEPTION;
        }
        return SERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION;
    }

}
