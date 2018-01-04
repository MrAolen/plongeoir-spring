package com.reeliant.plongeoir.repository;

import com.reeliant.plongeoir.entity.Category;
import com.reeliant.plongeoir.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
