package com.ctf.latampro.model.dto;

import com.ctf.latampro.model.entity.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HintsDTO {

    private Long id;
    private String description;
    private Challenge challenge;
}
