package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses={CategoryMapper.class}, componentModel = "spring")
public interface BookMapper{
    @Mapping(target="image", expression="java( java.util.Base64.getEncoder().encodeToString(book.getImage()))")
    BookDTO bookToBookDTO(Book book);
    @Mapping(target="image", expression="java( java.util.Base64.getDecoder().decode(book.getImage()))")
    Book bookDTOToBook(BookDTO book);
}