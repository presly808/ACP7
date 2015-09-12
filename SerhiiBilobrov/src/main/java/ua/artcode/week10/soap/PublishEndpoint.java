package ua.artcode.week10.soap;

import ua.artcode.week10.soap.endpoint.ServiceEndpointImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by serhii on 12.09.15.
 */
public class PublishEndpoint {

    public static void main(String[] args) {
        Endpoint.publish("http://192.168.1.45:9999/ws/car", new ServiceEndpointImpl());
    }
}
