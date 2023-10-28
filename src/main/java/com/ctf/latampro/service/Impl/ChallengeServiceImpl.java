package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.ChallengeDTO;
import com.ctf.latampro.model.entity.Challenge;
import com.ctf.latampro.repository.ChallengeRepository;
import com.ctf.latampro.service.ChallengeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChallengeServiceImpl implements ChallengeService {


    private final ChallengeRepository challengeRepository;
    private final ObjectMapper objectMapper;

    private static final Logger logger = Logger.getLogger(ChallengeServiceImpl.class);

    @Autowired
    public ChallengeServiceImpl(ChallengeRepository challengeRepository, ObjectMapper objectMapper) {
        this.challengeRepository = challengeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChallengeDTO create(ChallengeDTO challengeDTO) {
        return this.save(challengeDTO);
    }

    @Override
    public ChallengeDTO read(Long id) throws ResourceNotFoundException {
        if(challengeRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The challenge searched by id: "+id+" doesn't exist");
        logger.info("Challenge with ID "+id+" found");
        return objectMapper.convertValue(challengeRepository.findById(id), ChallengeDTO.class);
    }

    @Override
    public ChallengeDTO update(ChallengeDTO challengeDTO) throws ResourceNotFoundException {
        if(this.read(challengeDTO.getId()) == null)
            throw new ResourceNotFoundException("The challenge searched by id "+challengeDTO.getId()+" doesn't exist");
        logger.info("Challenge with ID "+challengeDTO.getId()+" updated");
        return this.save(challengeDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if(this.read(id) == null)
            throw new ResourceNotFoundException("The challenge searched by id "+id+" doesn't exist");
        challengeRepository.deleteById(id);
        logger.info("Challenge with ID "+id+" deleted");

    }

    @Override
    public Set<ChallengeDTO> getAll() {
        List<Challenge> challenges = challengeRepository.findAll();
        return challenges.stream()
                .map(challenge -> objectMapper.convertValue(challenge, ChallengeDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ChallengeDTO> getAllByCategory(Long id) throws ResourceNotFoundException {
        List<Challenge> challenges = challengeRepository.findAllByCategory_Id(id);
        return challenges.stream()
                .map(challenge -> objectMapper.convertValue(challenge, ChallengeDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ChallengeDTO> getAllByUser(Long id) throws ResourceNotFoundException {
        List<Challenge> challenges = challengeRepository.findAllByUser_Id(id);
        return challenges.stream()
                .map(challenge -> objectMapper.convertValue(challenge, ChallengeDTO.class))
                .collect(Collectors.toSet());
    }

    private ChallengeDTO save(ChallengeDTO challengeDTO) {
       Challenge challenge = objectMapper.convertValue(challengeDTO, Challenge.class);
         challenge = challengeRepository.save(challenge);
         return challengeDTO;
    }
}
