package com.keyin.golf_tournament_docker.rest.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {


    List<Tournament> findByStartDate(LocalDate startDate);
    List<Tournament> findByLocation(String location);

}
