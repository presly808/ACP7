package ua.artcode.pattern;

public class BuilderTest {

    public static void main(String[] args) {
        IPhoneBuilder builder = new IPhoneBuilder();


        IPhone iPhone = builder.appendCam("5.0")
                .appendColor("red")
                .appendHdd(32)
                .appendRam(4).build();

    }
}


class IPhone {

    private final String model;
    private final int ram;
    private final int hdd;
    private final String cam;
    private final String color;
    private final String country;

    public IPhone(String model, int ram, int hdd,
                  String cam, String color, String country) {
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

    public IPhoneBuilder appendRam(int ram) {
        this.ram = ram;
        return this;
    }

    public IPhoneBuilder appendHdd(int hdd) {
        this.hdd = hdd;
        return this;
    }

    public IPhoneBuilder appendCam(String cam) {
        this.cam = cam;
        return this;
    }

    public IPhoneBuilder appendColor(String color) {
        this.color = color;
        return this;
    }

    public IPhoneBuilder appendCountry(String country) {
        this.country = country;
        return this;
    }

    public IPhone build(){
        return new IPhone(model,ram,hdd,cam,color,country);
    }
}