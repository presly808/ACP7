package ua.artcode.patterns;

/**
 * Created by pikolo on 12.07.15.
 */
public class BuilderTest {

    public static void main(String[] args) {
        IPhoneBuilder builder = new IPhoneBuilder();
        builder.setCam("5.0");
        builder.setColor("Golden");
        builder.setModel("6+");
        builder.setHdd(164);
        builder.setRam(3);
    }

}

class IPhone {

    private final String model;
    private final int ram;
    private final int hdd;
    private final String cam;
    private final String color;
    private final String country;

    public IPhone(String model, int ram, int hdd, String cam, String color, String country) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.cam = cam;
        this.color = color;
        this.country = country;
    }

}

class IPhoneBuilder {

    private String model;
    private int ram;
    private int hdd;
    private String cam;
    private String color;
    private String country;

    public IPhoneBuilder() {
    }

    public IPhoneBuilder appendModel(String model) {
        this.model = model;
        return this;
    }

    public IPhone build() {
        return new IPhone(model,ram, hdd, cam, color, country);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
