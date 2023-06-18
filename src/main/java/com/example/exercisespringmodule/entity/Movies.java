package com.example.exercisespringmodule.entity;

import com.example.exercisespringmodule.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String movieTitle;

    @Enumerated(EnumType.STRING)
    private Category movieCategory;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;
    @Range(min=1,max =5)
    private double movieRate;
    private LocalDate creationDate;
    @ManyToMany()
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> cast;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasons;
}
