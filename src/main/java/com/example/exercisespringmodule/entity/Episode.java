package com.example.exercisespringmodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Episode {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String episodeName;
    private int episodeNumber;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
}
