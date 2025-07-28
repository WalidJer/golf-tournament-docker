package com.keyin.golf_tournament_docker.rest.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // GET /members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // POST /members
    @PostMapping
    public Member createMember(@RequestBody Member newMember) {
        return memberService.createMember(newMember);
    }

    // GET /members/{id}
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // GET /members/search/name?name=John
    @GetMapping("/search/name")
    public List<Member> searchByName(@RequestParam String name) {
        return memberService.searchByName(name);
    }

    // GET /members/search/phone?phone=7091234567
    @GetMapping("/search/phone")
    public Member searchByPhoneNumber(@RequestParam String phone) {
        return memberService.searchByPhoneNumber(phone);
    }

    // GET /members/search/membership-type?type=gold
    @GetMapping("/search/membership-type")
    public List<Member> searchByMembershipType(@RequestParam String type) {
        return memberService.searchByMembershipType(type);
    }

    // GET /members/search/tournament-date?date=2024-09-01
    @GetMapping("/search/tournament-date")
    public List<Member> searchByTournamentStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return memberService.searchByTournamentStartDate(date);
    }
}