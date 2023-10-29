package com.ctf.latampro.service;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.HintsDTO;

import java.util.Set;

public interface HintsService {

    HintsDTO create(HintsDTO hintsDTO);
    HintsDTO read(Long id) throws ResourceNotFoundException;
    HintsDTO update(HintsDTO hintsDTO) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
    Set<HintsDTO> getAll();

    Set<HintsDTO> getAllByChallenge(Long id);

}
