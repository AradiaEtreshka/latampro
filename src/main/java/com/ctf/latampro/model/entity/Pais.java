package com.ctf.latampro.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "paises")
public class Pais {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    public Pais(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
