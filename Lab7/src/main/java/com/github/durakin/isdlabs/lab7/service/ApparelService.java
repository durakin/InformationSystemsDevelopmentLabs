package com.github.durakin.isdlabs.lab7.service;

import com.github.durakin.isdlabs.lab7.entity.Apparel;

import java.math.BigDecimal;
import java.util.List;

public interface ApparelService {
    Integer add(Apparel apparel);
    Integer add (String apparelType, BigDecimal price, Integer inStock, String size, String sex);
    Apparel delete(Integer id);
    Apparel findById(Integer id);
    boolean update(Integer id, Integer newInStock, BigDecimal newPrice);
    List<Apparel> findByMaxPrice(Double maxPrice);
    List<Apparel> findAll();
}
