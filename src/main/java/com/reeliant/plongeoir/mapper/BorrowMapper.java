package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.BorrowDTO;
import com.reeliant.plongeoir.entity.Borrow;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses={BookMapper.class,UserMapper.class})
public interface BorrowMapper{

    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);

    BorrowDTO borrowToBorrowDTO(Borrow borrow);
    Borrow borrowDTOToBorrow(BorrowDTO borrow);
}
