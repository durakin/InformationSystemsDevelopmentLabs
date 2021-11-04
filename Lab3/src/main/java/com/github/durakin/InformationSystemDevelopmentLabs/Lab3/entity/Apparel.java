package com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity;

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

    public Double getPrice() {
        return price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public String getApparelType() {
        return apparelType;
    }

    public String getSize() {
        return size;
    }

    public String getSex() {
        return sex;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public void setApparelType(String apparelType) {
        this.apparelType = apparelType;
    }

    public void setSize(String size) {
        this.size = size;
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
                "\nPrice " + price +
                "\nLeft in stock " + inStock +
                '\n';
    }
}
