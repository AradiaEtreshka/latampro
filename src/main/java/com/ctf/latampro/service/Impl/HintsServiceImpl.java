package com.ctf.latampro.service.Impl;

import com.ctf.latampro.repository.HintsRepository;
import com.ctf.latampro.service.HintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HintsServiceImpl implements HintsService {

    private final HintsRepository hintsRepository;

    @Autowired
    public HintsServiceImpl(HintsRepository hintsRepository) {
        this.hintsRepository = hintsRepository;
    }
}
