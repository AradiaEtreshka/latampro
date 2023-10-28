package com.ctf.latampro.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @OneToMany(mappedBy = "category")
    private List<Challenge> challenges;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
