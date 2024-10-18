package com.example.demo.controllers;

import com.example.demo.dto.MemberDTO;
import com.example.demo.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping()
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping()
    public MemberDTO addMember(@RequestBody MemberDTO memberDTO) {
        return memberService.saveMember(memberDTO);
    }

    @PutMapping("/{id}")
    public MemberDTO updateMember(@PathVariable int id, @RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(id, memberDTO);
    }

    @DeleteMapping("/delete-member/{id}")
    public String deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return "Member deleted successfully";
    }

    @GetMapping("/{id}")
    public MemberDTO getMemberById(@PathVariable int id) {
        return memberService.getMember(id);
    }
}

