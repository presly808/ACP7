package ua.artcode.week10.soap.endpoint;

import ua.artcode.week10.soap.model.Car;
import ua.artcode.week10.soap.storage.CarsGarage;

import javax.jws.WebService;

@WebService(endpointInterface = "ua.artcode.week10.soap.endpoint.ServiceEndpoint")
public class ServiceEndpointImpl implements ServiceEndpoint {

    @Override
    public Car findById(int id) {
        return CarsGarage.getById(id);
    }
}
