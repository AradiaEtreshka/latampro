package com.ctf.latampro.service;


import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.AppUserDTO;

import java.util.Set;

public interface AppUserService {
    //crud

    AppUserDTO create(AppUserDTO appUserDTO);
    AppUserDTO read(Long id) throws ResourceNotFoundException;

    AppUserDTO update(AppUserDTO appUserDTO) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;

    Set<AppUserDTO> getAll();


}
