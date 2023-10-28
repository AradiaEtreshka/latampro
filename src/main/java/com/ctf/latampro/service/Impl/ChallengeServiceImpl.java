package com.ctf.latampro.service.Impl;

import com.ctf.latampro.repository.ChallengeRepository;
import com.ctf.latampro.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeServiceImpl(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }
}
