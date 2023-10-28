package com.ctf.latampro.service.Impl;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.AppUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AppUserServiceImplTest {

    @Autowired
    private AppUserServiceImpl appUserService;


    @Test

    public void ifAppUserCreatedCorrectly_returnNotNull() throws ResourceNotFoundException {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setNickname("Tequito");
        appUserDTO.setEmail("tequito@lalala.com");
        appUserDTO.setPassword("AB546");
        appUserService.create(appUserDTO);

        AppUserDTO appUserCreated = appUserService.read(1L);

        assertTrue(appUserCreated != null);


    }


}