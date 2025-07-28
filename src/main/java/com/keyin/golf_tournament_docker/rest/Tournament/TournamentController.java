package com.keyin.golf_tournament_docker.rest.Tournament;

import com.keyin.golf_tournament_docker.rest.Member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // GET /tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    // POST /tournaments
    @PostMapping
    public Tournament createTournament(@RequestBody TournamentDTO tournament) {
        return tournamentService.createTournament(tournament);
    }

    // GET /tournaments/{id}
    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    // GET /tournaments/search/start-date?date=2024-08-10
    @GetMapping("/search/start-date")
    public List<Tournament> searchByStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return tournamentService.searchByStartDate(date);
    }

    // GET /tournaments/search/location?location=Toronto
    @GetMapping("/search/location")
    public List<Tournament> searchByLocation(@RequestParam String location) {
        return tournamentService.searchByLocation(location);
    }

    // GET /tournaments/{id}/members
    @GetMapping("/{id}/members")
    public List<Member> getMembersInTournament(@PathVariable Long id) {
        return tournamentService.getMembersInTournament(id);
    }
}
