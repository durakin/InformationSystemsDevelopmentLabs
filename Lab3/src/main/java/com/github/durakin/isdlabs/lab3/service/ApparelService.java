package com.github.durakin.isdlabs.lab3.service;

import com.github.durakin.isdlabs.lab3.entity.Apparel;

import java.util.List;

public interface ApparelService {
    Integer add(Apparel apparel);
    boolean delete(Integer id);
    Apparel findById(Integer id);
    boolean update(Integer id, Integer newInStock, Double newPrice);
    List<Apparel> findByMaxPrice(Double maxPrice);
    List<Apparel> findAll();
}
