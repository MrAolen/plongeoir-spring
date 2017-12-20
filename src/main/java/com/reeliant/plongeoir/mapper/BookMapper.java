package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses={CategoryMapper.class})
public interface BookMapper{
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO book);
}