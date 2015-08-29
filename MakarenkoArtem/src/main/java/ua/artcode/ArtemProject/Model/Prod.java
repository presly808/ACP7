package ua.artcode.ArtemProject.Model;

/**
 * Created by HOME on 21.08.2015.
 */
public class Prod {

    private String Vurobnuk;
    private String Model;
    private int Processor;
    private long Memory;
    private long id;

    @Override
    public String toString() {
        return "pc{" +
                "Vurobnuk='" + Vurobnuk + '\'' +
                ", Model='" + Model + '\'' +
                ", Processor=" + Processor +
                ", Memory=" + Memory +
                ", id=" + id +
                '}';
    }

    public Prod(String vurobnuk, String model, int processor, long memory) {
        Vurobnuk = vurobnuk;
        Model = model;
        Processor = processor;
        Memory = memory;
    }

    public String getVurobnuk() {
        return Vurobnuk;
    }

    public void setVurobnuk(String vurobnuk) {
        Vurobnuk = vurobnuk;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getProcessor() {
        return Processor;
    }

    public void setProcessor(int processor) {
        Processor = processor;
    }

    public long getMemory() {
        return Memory;
    }

    public void setMemory(long memory) {
        Memory = memory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }





}
