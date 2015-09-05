package model;

import javax.persistence.*;

@Entity
@Table(name = "localization")
public class Localization extends IdEntity{
    @Column
    private String localizationName;
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Localization() {
    }

    public Localization(String localizationName) {
        this.localizationName = localizationName;
    }

    public String getLocalizationName() {
        return localizationName;
    }

    public void setLocalizationName(String localizationName) {
        this.localizationName = localizationName;
    }
}
