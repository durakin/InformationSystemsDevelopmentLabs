package com.github.durakin.isdlabs.lab6.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Apparel {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "\"inStock\"", nullable = false)
    private Integer inStock;

    @Column(name = "\"apparelType\"", nullable = false)
    private String apparelType;

    @Column
    private String size;

    @Column
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
