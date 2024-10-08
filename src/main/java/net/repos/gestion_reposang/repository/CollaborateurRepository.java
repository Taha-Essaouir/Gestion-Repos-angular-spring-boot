package net.repos.gestion_reposang.repository;
import net.repos.gestion_reposang.entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Long> {

    List<Collaborateur> findByTerminalAndFonction(String terminal, String fonction);

    List<Collaborateur> findAll();

    List<Collaborateur> findByMatriculeContaining(String matricule); //chercher un Collaborateur par son matricule

    List  <Collaborateur> findByCollaborateurs(Long collaborateurs);  //chercher un Collaborateur par son matricule
}