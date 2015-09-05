package model;


import javax.persistence.*;

import java.sql.Time;

@Entity
@Table
public class ServiceType extends IdEntity {
    @Column
    private String nameService;
    @Column
    private String typeOfService;
    @Column
    private Time timeToDo;
    @Column
    private long priceOfService;

    public ServiceType() {
    }

    public ServiceType(String nameService, String typeOfService, Time timeToDo, long priceOfService) {
        this.nameService = nameService;
        this.typeOfService = typeOfService;
        this.timeToDo = timeToDo;
        this.priceOfService = priceOfService;
    }

    public String getNameService() {
        return nameService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public Time getTimeToDo() {
        return timeToDo;
    }

    public long getPriceOfService() {
        return priceOfService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public void setTimeToDo(Time timeToDo) {
        this.timeToDo = timeToDo;
    }

    public void setPriceOfService(long priceOfService) {
        this.priceOfService = priceOfService;
    }
}
