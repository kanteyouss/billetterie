package com.billetterie.billetterie.evenement;

import com.billetterie.billetterie.evenement.dto.EvenementRequest;
import com.billetterie.billetterie.evenement.dto.EvenementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")
@RequiredArgsConstructor
public class EvenementController {
    private final EvenementService evenementService;


    /**
     * Crée un nouvel événement.
     *
     * @param evenementRequest les informations de l'événement à créer
     * @return l'événement créé
     */
    @PostMapping
    public EvenementResponse createEvenement(
            @RequestBody EvenementRequest evenementRequest) {

        return evenementService.createEvenement(evenementRequest);
    }
    /**
     * Récupère un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à récupérer.
     * @return EvenementResponse Les détails de l'événement récupéré.
     */
    @GetMapping("/{id}")
    public EvenementResponse getEvenementById(@PathVariable Long id) {
        return evenementService.getEvenementById(id);
    }

    /**
     * Récupère la liste de tous les événements.
     *
     * @return List<EvenementResponse> La liste des événements.
     */
    @GetMapping
    public List<EvenementResponse> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    /**
     * Modifie un événement existant.
     *
     * @param id L'identifiant de l'événement à modifier.
     * @param evenementRequest Les données de la requête pour modifier l'événement.
     * @return EvenementResponse Les détails de l'événement modifié.
     */
    @PutMapping("/{id}")
    public EvenementResponse updateEvenementById(
            @PathVariable Long id,
            @RequestBody EvenementRequest evenementRequest) {

        return evenementService.updateEvenementById(id, evenementRequest);
    }

    /**
     * Supprime un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à supprimer.
     * @return EvenementResponse Les détails de l'événement supprimé.
     */
    @DeleteMapping("/{id}")
    public EvenementResponse deleteEvenementById(@PathVariable Long id) {
        return evenementService.deleteEvenementById(id);
    }
}
