package com.springRunner.club.service.impl;

import com.springRunner.club.dto.ClubDto;
import com.springRunner.club.model.Club;
import com.springRunner.club.repository.ClubRepo;
import com.springRunner.club.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepo clubRepo;
    public ClubServiceImpl(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepo.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        return mapToClubDto(clubRepo.findById(clubId).get());
    }

    @Override
    public Club save(ClubDto clubDto) {
        return clubRepo.save(mapToClub(clubDto));
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepo.save(club);
    }

    private Club mapToClub(ClubDto club) {
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

    private ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}
