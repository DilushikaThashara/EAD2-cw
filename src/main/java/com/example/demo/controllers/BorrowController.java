package com.example.demo.controllers;

import com.example.demo.dto.BorrowDTO;
import com.example.demo.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping()
    public List<BorrowDTO> getAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @PostMapping()
    public BorrowDTO addBorrow(@RequestBody BorrowDTO borrowDTO) {
        return borrowService.saveBorrow(borrowDTO);
    }

    @PutMapping("/{id}")
    public BorrowDTO updateBorrow(@PathVariable int id, @RequestBody BorrowDTO borrowDTO) {
        return borrowService.updateBorrow(id, borrowDTO);
    }

    @DeleteMapping("/delete-borrow/{id}")
    public String deleteBorrow(@PathVariable int id) {
        borrowService.deleteBorrow(id);
        return "Borrow record deleted successfully";
    }

    @GetMapping("/{id}")
    public BorrowDTO getBorrowById(@PathVariable int id) {
        return borrowService.getBorrow(id);
    }
}

