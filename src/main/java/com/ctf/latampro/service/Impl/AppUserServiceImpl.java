package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.AppUserDTO;
import com.ctf.latampro.model.entity.AppUser;
import com.ctf.latampro.repository.AppUserRepository;
import com.ctf.latampro.service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final ObjectMapper objectMapper;

    private static final Logger logger = Logger.getLogger(AppUserServiceImpl.class);

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
        if (appUserRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("The patient searched by id: " + id + " doesn't exist");
        logger.info("AppUser with ID " + id + " found");
        return objectMapper.convertValue(appUserRepository.findById(id), AppUserDTO.class);
    }

    @Override
    public AppUserDTO update(AppUserDTO appUserDTO) throws ResourceNotFoundException {
        if (this.read(appUserDTO.getId()) == null)
            throw new ResourceNotFoundException("The patient searched by id " + appUserDTO.getId() + " doesn't exist");
        logger.info("AppUser with ID " + appUserDTO.getId() + " updated");
        return this.save(appUserDTO);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (this.read(id) == null)
            throw new ResourceNotFoundException("The patient searched by id: " + id + " doesn't exist");
        logger.info("AppUser with ID " + id + " deleted");
        appUserRepository.deleteById(id);

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

