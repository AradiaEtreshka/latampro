package com.ctf.latampro.repository;

import com.ctf.latampro.model.dto.ChallengeDTO;
import com.ctf.latampro.model.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    List<Challenge> findAllByCategory_Id(Long id);

    List<Challenge> findAllByUser_Id(Long id);

}
