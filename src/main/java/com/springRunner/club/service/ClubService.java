package com.springRunner.club.service;

import com.springRunner.club.dto.ClubDto;
import com.springRunner.club.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    ClubDto findClubById(Long clubId);
    Club save(ClubDto clubDto);

    void updateClub(ClubDto club);
}
