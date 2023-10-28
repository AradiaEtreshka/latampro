package com.ctf.latampro.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="hints")

public class Hints {

    private Long id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;
}
