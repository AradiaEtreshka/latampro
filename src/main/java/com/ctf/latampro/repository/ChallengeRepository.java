package com.ctf.latampro.repository;

import com.ctf.latampro.model.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
