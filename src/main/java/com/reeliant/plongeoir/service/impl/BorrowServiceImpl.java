package com.reeliant.plongeoir.service.impl;

import com.reeliant.plongeoir.repository.BorrowRepository;
import com.reeliant.plongeoir.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {

        @Autowired
        private BorrowRepository borrowRepository;

        @Override
        public boolean isBookBorrow(Long id) {
                if (borrowRepository.findOne(id) != null) {
                        return true;
                }
                return false;
        }
}
