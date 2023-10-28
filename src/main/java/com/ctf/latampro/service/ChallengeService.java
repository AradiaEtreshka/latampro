package com.ctf.latampro.service;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.ChallengeDTO;

import java.util.Set;

public interface ChallengeService {

    ChallengeDTO create(ChallengeDTO challengeDTO);
    ChallengeDTO read(Long id) throws ResourceNotFoundException;

    ChallengeDTO update(ChallengeDTO challengeDTO) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;

    Set<ChallengeDTO> getAll();

    Set<ChallengeDTO> getAllByCategory(Long id) throws ResourceNotFoundException;

    Set<ChallengeDTO> getAllByUser(Long id) throws ResourceNotFoundException;

}
