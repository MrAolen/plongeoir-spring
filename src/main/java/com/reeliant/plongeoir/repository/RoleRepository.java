package com.reeliant.plongeoir.repository;

import com.reeliant.plongeoir.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
