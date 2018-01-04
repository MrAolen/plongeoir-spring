package com.reeliant.plongeoir.repository;

import com.reeliant.plongeoir.entity.Book;
import com.reeliant.plongeoir.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
