package com.ctf.latampro.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Role role;

    @Column
    @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = false)
    private List<Challenge> challenges;

    @Column
    private Long puntaje;

    @Column
    @ManyToOne
    @JoinColumn(name = "pais_id") // nombre de la columna en la tabla usuarios que guarda el ID del país
    private String pais;

    public AppUser(String nickname, String email, String password, Role role, List<Challenge> challenges, Long puntaje, String pais) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.challenges = challenges;
        this.puntaje = puntaje;
        this.pais = pais;
    }



}
