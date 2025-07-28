package com.keyin.golf_tournament_docker.rest.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Create or add a new member
    public Member createMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    // Get member by ID
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    // Search for a member by name (if names can repeat, consider returning List<Member>)
    public List<Member> searchByName(String name) {
        return memberRepository.findByName(name);
    }

    // Search by membership type
    public List<Member> searchByMembershipType(String membershipType) {
        return memberRepository.findByMembershipType(membershipType);
    }

    // Search by phone number
    public Member searchByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    // Search members by tournament start date
    public List<Member> searchByTournamentStartDate(LocalDate startDate) {
        return memberRepository.findByTournaments_StartDate(startDate);
    }
}