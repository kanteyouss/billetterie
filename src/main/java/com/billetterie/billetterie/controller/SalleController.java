package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.SalleRequestDto;
import com.billetterie.billetterie.dto.SalleResponseDto;
import com.billetterie.billetterie.service.SalleService;
import com.billetterie.billetterie.utils.response.Response;
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
     * @return List<SalleResponseDto> La liste des salles.
     */
    @GetMapping
    public List<SalleResponseDto> getAllSalle() {
        return salleService.getAllSalle();
    }
    /**
     * Crée une nouvelle salle.
     * @param salleRequest Les données de la requête pour créer la salle.
     * @return SalleResponseDto Les détails de la salle créée.
     */
    @PostMapping
    public SalleResponseDto  createSalle(@RequestBody SalleRequestDto salleRequest) {
        return salleService.createSalle(salleRequest);
    }
    /**
     * Récupère une salle à partir de son identifiant.
     * @param id L'identifiant de la salle à récupérer.
     * @return SalleResponseDto Les détails de la salle récupérée.
     */
    @GetMapping("/{id}")
    public SalleResponseDto  getSalleById(@PathVariable Long id) {
        return salleService.getSalleById(id);
    }
    /**
     * Modifie une salle existante.
     * @param id L'identifiant de la salle à modifier.
     * @param salleRequest Les données de la requête pour modifier la salle.
     * @return SalleResponseDto Les détails de la salle modifiée.
     */
    @PutMapping("/{id}")
    public SalleResponseDto updatesalle(
            @PathVariable Long id,
            @RequestBody SalleRequestDto salleRequest) {
        return salleService.updatesalle(id, salleRequest);
    }
    /**
     * Supprime une salle à partir de son identifiant.
     * @param id L'identifiant de la salle à supprimer.
     * @return SalleResponseDto Les détails de la salle supprimée.
     */
    @DeleteMapping("/{id}")
    public SalleResponseDto deleteSalle(@PathVariable Long id) {
        return salleService.deleteSalle(id);
    }
}