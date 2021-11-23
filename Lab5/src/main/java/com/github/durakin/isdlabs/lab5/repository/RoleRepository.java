package com.github.durakin.isdlabs.lab5.repository;

import com.github.durakin.isdlabs.lab5.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}