package net.repos.gestion_reposang.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Repos {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long collaborateurs;
    private String nom;
    private String matricule;
    private String codeGroupe;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String terminal;
    private String fonction;
    private String typeRepos;
}