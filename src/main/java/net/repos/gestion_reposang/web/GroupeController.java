package net.repos.gestion_reposang.web;
import net.repos.gestion_reposang.entities.Collaborateur;
import net.repos.gestion_reposang.entities.Groupe;
import net.repos.gestion_reposang.entities.Repos;
import net.repos.gestion_reposang.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/groupes")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @GetMapping("/all")
    public ResponseEntity<List<Groupe>> findAll() {
        List<Groupe> group = groupeService.getAllGroupes();
        return ResponseEntity.ok(group);
    }

    @PostMapping("/create")
    public Groupe createGroupes(@RequestBody Groupe groupe) {
        return groupeService.createGroupes(groupe);
    }

    @DeleteMapping("/delete/{collaborateurs}")
    public ResponseEntity<?> deleteGroupes(@PathVariable Long collaborateurs) {
        groupeService.deleteGroupes(collaborateurs);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suivant")
    public ResponseEntity<List<Collaborateur>> afficherCollaborateurs(@RequestParam String terminal, @RequestParam String fonction) {
        try {
            List<Collaborateur> collaborateurs = groupeService.afficherCollaborateurs(terminal, fonction);
            return ResponseEntity.ok(collaborateurs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/precedent")
    public ResponseEntity<String> retourPagePrecedente() {
        return ResponseEntity.ok("Page Precedente");
    }

}