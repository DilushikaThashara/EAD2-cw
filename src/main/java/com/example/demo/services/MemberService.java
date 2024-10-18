package com.example.demo.services;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entities.Member;
import com.example.demo.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public MemberDTO saveMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        memberRepository.save(member);
        return memberDTO;
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberDTO> memberList = new ArrayList<>();
        for (Member member : members) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(member.getId());
            memberDTO.setName(member.getName());
            memberDTO.setEmail(member.getEmail());
            memberList.add(memberDTO);
        }
        return memberList;
    }

    public MemberDTO updateMember(int id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id).orElse(new Member());
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        memberRepository.save(member);
        return memberDTO;
    }

    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }

    public MemberDTO getMember(int id) {
        Member member = memberRepository.findById(id).orElse(new Member());
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setEmail(member.getEmail());
        return memberDTO;
    }
}

