package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "immunohistochemical_research")
public class ImmunohistochemicalResearch extends IdEntity{

    private Patient patient;
    private Reaction reaction;
    private ArrayList<Antibody> antibodies;
    private boolean isPositive;
    private long price;

    public ImmunohistochemicalResearch() {
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean isPositive) {
        this.isPositive = isPositive;
    }



}
