package model;

import javax.persistence.*;


@Entity
@Table(name = "immunohistochemical_research")
public class ImmunohistochemicalResearch extends IdEntity{
   @OneToOne//(mappedBy = "antibody")
   @JoinColumn (name = "antibody_id", referencedColumnName = "id")
    private Antibody antibody;
    @Column
    private String reaction;
    @ManyToOne
    @JoinColumn(name = "immunohistochemical_research_id", referencedColumnName = "id")
    private Patient diagnose;

    public ImmunohistochemicalResearch() {
    }

    public Antibody getAntibody() {
        return antibody;
    }

    public void setAntibody(Antibody antibody) {
        this.antibody = antibody;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

}
