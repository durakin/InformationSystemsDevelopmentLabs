package com.github.durakin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;

public class Apparel {
    private Integer id;

    private Double price;

    private Integer inStock;

    private String apparelType;

    private String size;

    private String sex;

    public Apparel() {
    }

    public Apparel(Integer id, Double price, Integer inStock, String apparelType, String size, String sex) {
        this.id = id;
        this.price = price;
        this.inStock = inStock;
        this.apparelType = apparelType;
        this.size = size;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getApparelType() {
        return apparelType;
    }

    public void setApparelType(String apparelType) {
        this.apparelType = apparelType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Apparel [");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", inStock=").append(inStock);
        sb.append(", apparelType='").append(apparelType).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
