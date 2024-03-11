package com.springRunner.club.repository;

import com.springRunner.club.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String title);
}
