package com.ctf.latampro.controller;

import com.ctf.latampro.model.dto.AppUserDTO;
import com.ctf.latampro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;


}
