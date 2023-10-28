package com.ctf.latampro.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private Set<ChallengeDTO> challenges;

}
