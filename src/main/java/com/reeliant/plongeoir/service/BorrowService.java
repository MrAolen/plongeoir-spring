package com.reeliant.plongeoir.service;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.BorrowDTO;

import java.util.List;

public interface BorrowService {

    boolean isBookBorrow(Long id);

    List<BorrowDTO> getBorrowedBookByUser(Long id);

    void borrowBook(Long id);

    void deleteBorrow(Long id);
}
