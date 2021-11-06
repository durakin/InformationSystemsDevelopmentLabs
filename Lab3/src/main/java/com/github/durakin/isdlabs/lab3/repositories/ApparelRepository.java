package com.github.durakin.isdlabs.lab3.repositories;

import com.github.durakin.isdlabs.lab3.entities.Apparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApparelRepository extends JpaRepository<Apparel, Integer> {
    List<Apparel> findDistinctByPriceLessThan(Double price);
}
