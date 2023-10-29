package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.HintsDTO;
import com.ctf.latampro.model.entity.Hints;
import com.ctf.latampro.repository.HintsRepository;
import com.ctf.latampro.service.HintsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HintsServiceImpl implements HintsService {

    private final HintsRepository hintsRepository;
    private static final Logger logger = Logger.getLogger(HintsServiceImpl.class);

    private final ObjectMapper objectMapper;


    @Autowired
    public HintsServiceImpl(HintsRepository hintsRepository, ObjectMapper objectMapper) {
        this.hintsRepository = hintsRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public HintsDTO create(HintsDTO hintsDTO) {
        return this.save(hintsDTO);
    }

    private HintsDTO save(HintsDTO hintsDTO) {
        Hints hints = objectMapper.convertValue(hintsDTO, Hints.class);
        hints = hintsRepository.save(hints);
        logger.info("Hints with ID "+hints.getId()+" saved");
        return objectMapper.convertValue(hints, HintsDTO.class);
    }

    @Override
    public HintsDTO read(Long id) throws ResourceNotFoundException {
        if (hintsRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The hints searched by id: " + id + " doesn't exist");
        logger.info("Hints with ID " + id + " found");
        return objectMapper.convertValue(hintsRepository.findById(id), HintsDTO.class);
    }

    @Override
    public HintsDTO update(HintsDTO hintsDTO) throws ResourceNotFoundException {
        if (this.read(hintsDTO.getId()) == null)
            throw new ResourceNotFoundException("The hints searched by id " + hintsDTO.getId() + " doesn't exist");
        logger.info("Hints with ID " + hintsDTO.getId() + " updated");
        return this.save(hintsDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (this.read(id) == null)
            throw new ResourceNotFoundException("The hints searched by id: " + id + " doesn't exist");
        logger.info("Hints with ID " + id + " deleted");
        hintsRepository.deleteById(id);

    }

    @Override
    public Set<HintsDTO> getAll() {
        List<Hints> hints = hintsRepository.findAll();
        return hints.stream().map(hints1 -> objectMapper.convertValue(hints1, HintsDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<HintsDTO> getAllByChallenge(Long id) {
        List<Hints> hints = hintsRepository.findAllByChallengeId(id);
        return hints.stream().map(hints1 -> objectMapper.convertValue(hints1, HintsDTO.class))
                .collect(Collectors.toSet());
    }
}
