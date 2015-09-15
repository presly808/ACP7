import ua.artcode.week10.soap.endpoint.Car;
import ua.artcode.week10.soap.endpoint.ServiceEndpoint;
import ua.artcode.week10.soap.endpoint.ServiceEndpointImplService;

/**
 * Created by tokar on 12.09.2015.
 */
public class RunClient {

    public static void main(String[] args) {
        ServiceEndpointImplService endpoint =new ServiceEndpointImplService();
        ServiceEndpoint serviceEndpoint =endpoint.getServiceEndpointImplPort();
        Car car = serviceEndpoint.findById(2);
        //System.out.printf();




    }



}
