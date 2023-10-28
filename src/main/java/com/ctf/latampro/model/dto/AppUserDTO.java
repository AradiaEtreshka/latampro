package com.ctf.latampro.model.dto;

import com.ctf.latampro.model.entity.Challenge;
import com.ctf.latampro.model.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AppUserDTO {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Role role;
    private List<Challenge> challenges;
    private Long puntaje;
    private String pais;

}
