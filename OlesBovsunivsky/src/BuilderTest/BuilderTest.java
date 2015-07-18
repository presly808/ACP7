package BuilderTest;

/**
 * Created by Legion on 12.07.2015.
 */
public class BuilderTest {
    public static void main(String[] args) {
        IphoneBilder ib =  new IphoneBilder();
    }

}

class Iphone{
    private final String model;
    private final int ram;
    private final int hdd;
    private final String cam;
    private final String color;
    private final String count  ;


    public Iphone(String model, int ram, int hdd, String cam, String color, String count) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.cam = cam;
        this.color = color;
        this.count = count;
    }

}

class IphoneBilder{
    private  String model;
    private  int ram;
    private  int hdd;
    private  String cam;
    private  String color;
    private  String count ;

    public IphoneBilder(){}

    public Iphone build(){
        return new Iphone(model, ram, hdd, cam, color, count);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getCam() {
        return cam;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}