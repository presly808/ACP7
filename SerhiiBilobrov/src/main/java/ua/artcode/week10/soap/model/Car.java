package ua.artcode.week10.soap.model;

/**
 * Created by serhii on 12.09.15.
 */
public class Car {

    private int id;
    private String model;
    private double price;
    private int speed;

    public Car(int id, String model, double price, int speed) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.speed = speed;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append(", speed=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}
