package com.reeliant.plongeoir.repository;

import com.reeliant.plongeoir.entity.MetaData;
import com.reeliant.plongeoir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository<MetaData, Long>{
    MetaData findByKey(String key);
}
