package ua.artcode.week10.soap.storage;

import ua.artcode.week10.soap.model.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 12.09.15.
 */
public class CarsGarage {

    private static final Map<Integer,Car> map = new HashMap<>();

    static {
        map.put(1, new Car(1,"Toyota", 22000,230));
        map.put(2, new Car(2,"Mercedes", 120000,300));
        map.put(3, new Car(3,"Suzuki", 13000,150));
        map.put(4, new Car(4,"Jihuli", 1500,110));
    }

    public static Car getById(int id) {
        return map.get(id);
    }

    public static void addCar(Car car){
        map.put(car.getId(),car);
    }
}
