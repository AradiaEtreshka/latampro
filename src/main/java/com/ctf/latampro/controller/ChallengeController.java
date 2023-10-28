package com.ctf.latampro.controller;

import com.ctf.latampro.model.dto.ChallengeDTO;
import com.ctf.latampro.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
