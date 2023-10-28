package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.AppUserDTO;
import com.ctf.latampro.model.entity.AppUser;
import com.ctf.latampro.repository.AppUserRepository;
import com.ctf.latampro.service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, ObjectMapper objectMapper) {
        this.appUserRepository = appUserRepository;
        this.objectMapper = objectMapper;
    }

    @Override

    public AppUserDTO create(AppUserDTO appUserDTO) {
        return this.save(appUserDTO);
    }

    @Override
    public AppUserDTO read(Long id) throws ResourceNotFoundException{
        return null;
    }

    @Override
    public AppUserDTO update(AppUserDTO appUserDTO) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<AppUserDTO> getAll() {
        List<AppUser> appUsers = appUserRepository.findAll();
        return appUsers.stream().map(appUser -> objectMapper.convertValue(appUser, AppUserDTO.class)).collect(Collectors.toSet());
    }

    private AppUserDTO save(AppUserDTO appUserDTO) {
        return objectMapper.convertValue(appUserRepository.save(objectMapper.convertValue(appUserDTO, AppUser.class)), AppUserDTO.class);
    }
}

