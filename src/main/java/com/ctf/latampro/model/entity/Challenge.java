package com.ctf.latampro.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="desafios")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private String category;

    @Column
    private String flag;

    @Column
    private Long points;

    @Column
    @OneToMany(mappedBy = "challenge", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = false)
    private List<Hints> hints;

    @Column
    private Boolean solved;

    @Column
    private Boolean active;

    @Column
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    public Challenge(String name, String description, String category, String flag, Long points, Hints hints, Boolean solved, Boolean active, AppUser appUser) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.flag = flag;
        this.points = points;
        this.hints = (List<Hints>) hints;
        this.solved = solved;
        this.active = active;
        this.appUser = appUser;
    }

}
