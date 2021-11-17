package com.github.durakin.isdlabs.lab4.form;

import javax.validation.constraints.*;

public class ApparelForm {

    @NotNull(message = "Can't be null")
    @Positive(message = "Must be positive")
    private int id;

    @NotBlank(message = "Can't be blank")
    private String type;

    private String size;

    private char sex;

    @NotNull(message = "Can't be null")
    @Positive(message = "Must be positive")
    private double price;

    @NotNull(message = "Can't be null")
    @PositiveOrZero(message = "Can't be negative")
    private int inStock;


    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public char getSex() {
        return sex;
    }

    public double getPrice() {
        return price;
    }

    public int getInStock() {
        return inStock;
    }
}
