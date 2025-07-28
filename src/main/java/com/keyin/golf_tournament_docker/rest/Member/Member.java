package com.keyin.golf_tournament_docker.rest.Member;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.golf_tournament_docker.rest.Tournament.Tournament;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate membershipDate;
    private int durationOfMembership;
    private String membershipType;

    @JsonIgnore
    @ManyToMany(mappedBy = "participatingMembers")
    private List<Tournament> tournaments;

    public Member() {
    }


    public Member(Long id, String name, String address, String email, String phoneNumber, LocalDate membershipDate, int durationOfMembership, String membershipType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipDate = membershipDate;
        this.durationOfMembership = durationOfMembership;
        this.membershipType = membershipType;
    }

    public Member(Long id, String name, String address, String email, String phoneNumber, LocalDate membershipDate, int durationOfMembership, String membershipType, List<Tournament> tournaments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipDate = membershipDate;
        this.durationOfMembership = durationOfMembership;
        this.membershipType = membershipType;
        this.tournaments = tournaments;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public int getDurationOfMembership() {
        return durationOfMembership;
    }


    public void setDurationOfMembership(int durationOfMembership) {
        this.durationOfMembership = durationOfMembership;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }


    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

}
