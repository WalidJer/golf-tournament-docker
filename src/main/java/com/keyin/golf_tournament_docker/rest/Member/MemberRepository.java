package com.keyin.golf_tournament_docker.rest.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByName(String name);
    Member findByPhoneNumber(String phoneNumber);
    List<Member> findByMembershipType(String membershipType);
    List<Member> findByTournaments_StartDate(LocalDate startDate);
}
