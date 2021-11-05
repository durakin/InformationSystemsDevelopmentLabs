package com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components;

import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity.Apparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("apparelRepository")
public interface ApparelRepository extends JpaRepository<Apparel, Integer> {
    
}

