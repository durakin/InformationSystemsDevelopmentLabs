package com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components;

import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity.Apparel;

import java.util.List;
import java.util.Optional;

public interface ApparelDao {
    List<Apparel> findAll();
    List<Apparel> findByType(String type);
    Optional<Apparel> findById(int id);
    void updateById(int id, Apparel apparel);
    void insert(Apparel apparel);
    void removeById(int id);
}
