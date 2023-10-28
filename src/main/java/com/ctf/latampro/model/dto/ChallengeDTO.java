package com.ctf.latampro.model.dto;

import com.ctf.latampro.model.entity.AppUser;
import com.ctf.latampro.model.entity.Hints;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChallengeDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private String flag;
    private Long points;
    private List<Hints> hints;
    private Boolean solved;
    private Boolean active;
    private AppUser appUser;



}
