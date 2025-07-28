package com.keyin.golf_tournament_docker.rest.Tournament;


import com.keyin.golf_tournament_docker.rest.Member.Member;
import com.keyin.golf_tournament_docker.rest.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberService memberService;

    public Tournament createTournament(TournamentDTO request) {
        Tournament tournament = new Tournament();
        tournament.setStartDate(request.getStartDate());
        tournament.setEndDate(request.getEndDate());
        tournament.setLocation(request.getLocation());
        tournament.setEntryFee(request.getEntryFee());
        tournament.setPrizeAmount(request.getPrizeAmount());

        List<Member> members = List.of();

        if (request.getMemberIds() != null && !request.getMemberIds().isEmpty()) {
            members = request.getMemberIds().stream()
                    .map(memberService::getMemberById)
                    .toList();
        }

        tournament.setParticipatingMembers(members);
        return tournamentRepository.save(tournament);
    }

    // Get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Get tournament by ID
    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + id));
    }

    // Search tournaments by start date
    public List<Tournament> searchByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    // Search tournaments by location (exact match)
    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    // Get all members participating in a tournament
    public List<Member> getMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + tournamentId));
        return tournament.getParticipatingMembers();
    }
}
