package com.example.exercisespringmodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@SuppressWarnings("ALL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Season {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private int numriISezonit;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;

}
