import ua.artcode.week10.soap.endpoint.Car;
import ua.artcode.week10.soap.endpoint.ServiceEndpoint;
import ua.artcode.week10.soap.endpoint.ServiceEndpointImplService;

/**
 * Created by serhii on 12.09.15.
 */
public class RunClient {

    public static void main(String[] args) {
        ServiceEndpointImplService endpoint = new ServiceEndpointImplService();
        ServiceEndpoint serviceEndpoint = endpoint.getServiceEndpointImplPort();

        Car car = serviceEndpoint.findById(1);
        System.out.printf("id %d, model %s, price %.2f, speed %d",
                car.getId(), car.getModel(),
                car.getPrice(), car.getSpeed());

    }

}
