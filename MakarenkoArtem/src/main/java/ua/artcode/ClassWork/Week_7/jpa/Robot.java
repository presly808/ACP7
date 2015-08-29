package ua.artcode.ClassWork.Week_7.jpa;

import javax.persistence.*;
import java.util.Date;

// MAPPING
@Entity
@Table(name = "robots")
public class Robot {

    // must have
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 20)
    private String model;

    // will be column in table with default config
    private double price;

    @Temporal(TemporalType.DATE)
    private Date creationDate = new Date();

    @Enumerated(EnumType.STRING)
    private RobotType robotType;

    @Transient
    private String tempKey;
    // must have
    public Robot() {
    }

    public Robot(String model, double price,
                 Date creationDate, RobotType robotType) {
        this.model = model;
        this.price = price;
        this.creationDate = creationDate;
        this.robotType = robotType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public void setRobotType(RobotType robotType) {
        this.robotType = robotType;
    }

    public String getTempKey() {
        return tempKey;
    }

    public void setTempKey(String tempKey) {
        this.tempKey = tempKey;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Robot{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", robotType=").append(robotType);
        sb.append('}');
        return sb.toString();
    }
}
