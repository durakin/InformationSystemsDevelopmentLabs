package com.github.durakin;


import java.io.Serializable;
import java.math.BigDecimal;

public class Apparel implements Serializable {

    private Integer id;

    private BigDecimal price;

    private Integer inStock;

    private String apparelType;

    private String size;

    private String sex;

    public Apparel() {
    }

    public Apparel(Integer id, BigDecimal price, Integer inStock, String apparelType, String size, String sex) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        return "id " + id +
                "\nType " + apparelType +
                "\nSex " + sex +
                "\nSize " + size +
                "\nPrice " + String.format("%.2f", price) +
                "\nLeft in stock " + inStock +
                '\n';
    }
}
