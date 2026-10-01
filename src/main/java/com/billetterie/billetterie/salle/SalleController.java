package com.billetterie.billetterie.salle;

import com.billetterie.billetterie.salle.dto.SalleRequest;
import com.billetterie.billetterie.salle.dto.SalleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salle")
public class SalleController {

    private final SalleService salleService;
    /**
     * @Param Récupère la liste de toutes les salles.
     * @return List<SalleResponse> La liste des salles.
     */
    @GetMapping
    public List<SalleResponse> getAllSalle() {
        return salleService.getAllSalle();
    }
    /**
     * Crée une nouvelle salle.
     * @param salleRequest Les données de la requête pour créer la salle.
     * @return SalleResponse Les détails de la salle créée.
     */
    @PostMapping
    public SalleResponse createSalle(@RequestBody SalleRequest salleRequest) {
        return salleService.createSalle(salleRequest);
    }
    /**
     * Récupère une salle à partir de son identifiant.
     * @param id L'identifiant de la salle à récupérer.
     * @return SalleResponse Les détails de la salle récupérée.
     */
    @GetMapping("/{id}")
    public SalleResponse getSalleById(@PathVariable Long id) {
        return salleService.getSalleById(id);
    }
    /**
     * Modifie une salle existante.
     * @param id L'identifiant de la salle à modifier.
     * @param salleRequest Les données de la requête pour modifier la salle.
     * @return SalleResponse Les détails de la salle modifiée.
     */
    @PutMapping("/{id}")
    public SalleResponse updatesalle(
            @PathVariable Long id,
            @RequestBody SalleRequest salleRequest) {

        return salleService.updatesalle(id, salleRequest);
    }
    /**
     * Supprime une salle à partir de son identifiant.
     * @param id L'identifiant de la salle à supprimer.
     * @return SalleResponse Les détails de la salle supprimée.
     */
    @DeleteMapping("/{id}")
    public SalleResponse deleteSalle(@PathVariable Long id) {
        return salleService.deleteSalle(id);
    }
}