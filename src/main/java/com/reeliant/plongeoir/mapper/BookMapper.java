package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses={CategoryMapper.class}, componentModel = "spring")
public interface BookMapper{
    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO book);
}