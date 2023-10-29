package com.ctf.latampro.controller;

import com.ctf.latampro.exceptions.ResourceNotFoundException;
import com.ctf.latampro.model.dto.ChallengeDTO;
import com.ctf.latampro.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @PostMapping("/create")
    public ResponseEntity<?> addChallenge(@RequestBody ChallengeDTO challengeDTO) {
        challengeService.create(challengeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateChallenge(@RequestBody ChallengeDTO challengeDTO) throws ResourceNotFoundException {
        challengeService.update(challengeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChallenge(@PathVariable("id") Long id) throws ResourceNotFoundException {
        challengeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
