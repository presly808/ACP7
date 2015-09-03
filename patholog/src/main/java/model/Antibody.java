package model;

import javax.persistence.*;

@Entity
@Table (name = "antibodies")
public class Antibody  extends IdEntity{

    /*@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;*/

    @Column(unique=true, nullable=false)
    private String name;
    @Column(unique=true, nullable=false)
    private String description;
    @Column(unique=true, nullable=false)
    private long price;
    @Column(unique=true, nullable=false)
    private boolean isAvailable;

    public Antibody() {
    }

    public Antibody(String name, String description, long price, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return name + " - " + description + ", price = " + price + (isAvailable ? ", available" : ", absent");
    }
}
