package com.example.demo.services;

import com.example.demo.dto.BorrowDTO;
import com.example.demo.entities.Borrow;
import com.example.demo.repositories.BorrowRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    public BorrowDTO saveBorrow(BorrowDTO borrowDTO) {
        Borrow borrow = new Borrow();
        borrow.setId(borrowDTO.getId());
        borrow.setBookId(borrowDTO.getBookId());
        borrow.setMemberId(borrowDTO.getMemberId());
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setReturnDate(borrowDTO.getReturnDate());
        borrowRepository.save(borrow);
        return borrowDTO;
    }

    public List<BorrowDTO> getAllBorrows() {
        List<Borrow> borrows = borrowRepository.findAll();
        List<BorrowDTO> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            BorrowDTO borrowDTO = new BorrowDTO();
            borrowDTO.setId(borrow.getId());
            borrowDTO.setBookId(borrow.getBookId());
            borrowDTO.setMemberId(borrow.getMemberId());
            borrowDTO.setBorrowDate(borrow.getBorrowDate());
            borrowDTO.setReturnDate(borrow.getReturnDate());
            borrowList.add(borrowDTO);
        }
        return borrowList;
    }

    public BorrowDTO updateBorrow(int id, BorrowDTO borrowDTO) {
        Borrow borrow = borrowRepository.findById(id).orElse(new Borrow());
        borrow.setBookId(borrowDTO.getBookId());
        borrow.setMemberId(borrowDTO.getMemberId());
        borrow.setBorrowDate(borrowDTO.getBorrowDate());
        borrow.setReturnDate(borrowDTO.getReturnDate());
        borrowRepository.save(borrow);
        return borrowDTO;
    }

    public void deleteBorrow(int id) {
        borrowRepository.deleteById(id);
    }

    public BorrowDTO getBorrow(int id) {
        Borrow borrow = borrowRepository.findById(id).orElse(new Borrow());
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setId(borrow.getId());
        borrowDTO.setBookId(borrow.getBookId());
        borrowDTO.setMemberId(borrow.getMemberId());
        borrowDTO.setBorrowDate(borrow.getBorrowDate());
        borrowDTO.setReturnDate(borrow.getReturnDate());
        return borrowDTO;
    }
}

