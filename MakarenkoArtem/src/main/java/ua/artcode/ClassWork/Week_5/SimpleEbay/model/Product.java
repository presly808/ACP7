package ua.artcode.ClassWork.Week_5.SimpleEbay.model;

import java.math.BigDecimal;

public class Product {

    private long id;
    private BigDecimal price;
    private String title;
    private String desc;

    public Product(BigDecimal price, String title, String desc) {
        this.price = price;
        this.title = title;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", title='").append(title).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
