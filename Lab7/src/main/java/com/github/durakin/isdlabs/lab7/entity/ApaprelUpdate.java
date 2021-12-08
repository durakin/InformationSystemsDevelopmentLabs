package com.github.durakin.isdlabs.lab7.entity;

import java.math.BigDecimal;

public class ApaprelUpdate {
    private int newInStock;
    private BigDecimal newPrice;

    public int getNewInStock() {
        return newInStock;
    }

    public void setNewInStock(int newInStock) {
        this.newInStock = newInStock;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }
}
