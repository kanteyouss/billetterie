package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.EvenementRequestDto;
import com.billetterie.billetterie.dto.EvenementResponseDto;
import com.billetterie.billetterie.service.EvenementService;
import com.billetterie.billetterie.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")

public class EvenementController {
    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    /**
     * Crée un nouvel événement.
     *
     * @param evenementRequest les informations de l'événement à créer
     * @return l'événement créé
     */
    @PostMapping
    public EvenementResponseDto createEvenement(
            @RequestBody EvenementRequestDto evenementRequest) {

        return evenementService.createEvenement(evenementRequest);
    }
    /**
     * Récupère un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à récupérer.
     * @return EvenementResponseDto Les détails de l'événement récupéré.
     */
    @GetMapping("/{id}")
    public EvenementResponseDto getEvenementById(@PathVariable Long id) {
        return evenementService.getEvenementById(id);
    }

    /**
     * Récupère la liste de tous les événements.
     *
     * @return List<EvenementResponseDto> La liste des événements.
     */
    @GetMapping
    public List<EvenementResponseDto> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    /**
     * Modifie un événement existant.
     *
     * @param id L'identifiant de l'événement à modifier.
     * @param evenementRequest Les données de la requête pour modifier l'événement.
     * @return EvenementResponseDto Les détails de l'événement modifié.
     */
    @PutMapping("/{id}")
    public EvenementResponseDto updateEvenementById(@PathVariable Long id, @RequestBody EvenementRequestDto evenementRequest) {
        return evenementService.updateEvenementById(id, evenementRequest);
    }

    /**
     * Supprime un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à supprimer.
     * @return EvenementResponseDto Les détails de l'événement supprimé.
     */
    @DeleteMapping("/{id}")
    public EvenementResponseDto deleteEvenementById(@PathVariable Long id) {
        return evenementService.deleteEvenementById(id);
    }
}
