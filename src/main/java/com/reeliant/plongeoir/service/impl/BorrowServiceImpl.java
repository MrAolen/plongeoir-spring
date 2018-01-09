package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.dto.BookDTO;
import com.reeliant.plongeoir.dto.BorrowDTO;
import com.reeliant.plongeoir.entity.Book;
import com.reeliant.plongeoir.entity.Borrow;
import com.reeliant.plongeoir.entity.User;
import com.reeliant.plongeoir.mapper.BookMapper;
import com.reeliant.plongeoir.mapper.BorrowMapper;
import com.reeliant.plongeoir.repository.BookRepository;
import com.reeliant.plongeoir.repository.BorrowRepository;
import com.reeliant.plongeoir.repository.UserRepository;
import com.reeliant.plongeoir.service.BorrowService;
import com.reeliant.plongeoir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

        @Autowired
        private BorrowRepository borrowRepository;

        @Autowired
        private BorrowMapper borrowMapper;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private UserService userService;

        @Override
        public boolean isBookBorrow(Long id) {
                if (borrowRepository.findOne(id) != null) {
                        return true;
                }
                return false;
        }

        @Override
        public List<BorrowDTO> getBorrowedBookByUser(Long id) {
                List<BorrowDTO> results = borrowRepository.findByUserId(id).stream().map(e -> borrowMapper.borrowToBorrowDTO(e)).collect(Collectors.toList());
                if (results == null) {
                        return new ArrayList<>();
                }
                return  results;
        }

        @Override
        public void borrowBook(Long id) {
                User currentUser = userRepository.findOne(userService.getCurrentUser().getId());
                Book book = bookRepository.findOne(id);

                Borrow borrow = new Borrow();
                borrow.setBook(book);
                borrow.setUser(currentUser);

                borrowRepository.save(borrow);
        }

        @Override
        public void deleteBorrow(Long id) {
                borrowRepository.delete(id);
        }
}
