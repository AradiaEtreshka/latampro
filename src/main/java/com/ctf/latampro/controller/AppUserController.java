package com.ctf.latampro.controller;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.AppUserDTO;
import com.ctf.latampro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/create")
    public ResponseEntity<?> addUser(AppUserDTO appUserDTO) {
        appUserService.create(appUserDTO);
        return ResponseEntity.ok("User created");
    }

   @GetMapping("/read/all")
    public ResponseEntity<?> readAllUser() {
        return ResponseEntity.ok(appUserService.getAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readUser(Long id) throws ResourceNotFoundException {
        AppUserDTO appUserDTOFound = appUserService.read(id);
        return ResponseEntity.ok(appUserDTOFound);
    }

    @PostMapping("/update")
    public  ResponseEntity<?> updateUser(AppUserDTO appUserDTO) throws ResourceNotFoundException {
        appUserService.update(appUserDTO);
        return ResponseEntity.ok("User updated");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(Long id) throws ResourceNotFoundException {
        appUserService.delete(id);
        return ResponseEntity.ok("User Deleted");
    }


}
