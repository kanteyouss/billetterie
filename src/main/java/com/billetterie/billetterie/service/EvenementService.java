package com.billetterie.billetterie.service;

import com.billetterie.billetterie.dto.EvenementRequestDto;
import com.billetterie.billetterie.dto.EvenementResponseDto;
import com.billetterie.billetterie.entity.Evenement;
import com.billetterie.billetterie.repository.EvenementRepository;
import com.billetterie.billetterie.entity.Salle;
import com.billetterie.billetterie.repository.SalleRepository;
import com.billetterie.billetterie.dto.SalleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EvenementService {
    private final EvenementRepository evenementRepository;
    private final SalleRepository salleRepository;

    /**
     * Convertit une entité événement en objet de réponse.
     *
     * @param evenement L'entité événement à convertir.
     * @return EvenementResponseDto Les détails de l'événement converti.
     */
    public EvenementResponseDto toDto(Evenement evenement) {
        return EvenementResponseDto.builder()
                .id(evenement.getId())
                .titre(evenement.getTitre())
                .description(evenement.getDescription())
                .horaire(evenement.getHoraire())
                .placementLibre(evenement.getPlacementLibre())
                .salle(SalleResponseDto.builder()
                        .id(evenement.getSalle().getId())
                        .nom(evenement.getSalle().getNom())
                        .capacite(evenement.getSalle().getCapacite())
                        .adresse(evenement.getSalle().getAdresse())
                        .build())
                .build();
    }
    /**
     * Convertit les données d'une requête en entité événement.
     *
     * @param evenementRequest Les données de la requête pour créer l'événement.
     * @param salle La salle associée à l'événement.
     * @return Evenement L'entité événement créée.
     */
    public Evenement toEntity(EvenementRequestDto evenementRequest, Salle salle) {
        return Evenement.builder()
                .titre(evenementRequest.getTitre())
                .description(evenementRequest.getDescription())
                .horaire(evenementRequest.getHoraire())
                .placementLibre(evenementRequest.getPlacementLibre())
                .salle(salle)
                .build();
    }
    /**
     * Crée un nouvel événement.
     *
     * @param evenementRequest les informations de l'événement à créer
     * @return l'événement créé
     */
    public EvenementResponseDto createEvenement(EvenementRequestDto evenementRequest) {
        Salle salle = salleRepository.findById(evenementRequest.getSalleId()).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
        if (evenementRequest.getHoraire().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("L'horaire de l'événement ne peut pas être dans le passé");
            }
        return toDto(evenementRepository.save(toEntity(evenementRequest,salle)));
    }
    /**
     * Récupère un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à récupérer.
     * @return EvenementResponseDto Les détails de l'événement récupéré.
     */
    public EvenementResponseDto getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Événement non trouvé"));
        return toDto(evenement);
    }
    /**
     * Récupère la liste de tous les événements.
     *
     * @return List<EvenementResponseDto> La liste des événements.
     */

    public List<EvenementResponseDto> getAllEvenements() {
        List<Evenement> evenements = evenementRepository.findAll();
        return evenements.stream()
                .map(this::toDto)
                .toList();
    }
    /**
     * Modifie un événement existant.
     *
     * @param id L'identifiant de l'événement à modifier.
     * @param evenementRequest Les données de la requête pour modifier l'événement.
     * @return EvenementResponseDto Les détails de l'événement modifié.
     */
    public EvenementResponseDto updateEvenementById(Long id, EvenementRequestDto evenementRequest) {
        Evenement evenement = evenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Événement non trouvé"));
        if (evenementRequest.getHoraire().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("L'horaire de l'événement ne peut pas être dans le passé");
        }
        evenement.setTitre(evenementRequest.getTitre());
        evenement.setDescription(evenementRequest.getDescription());
        evenement.setHoraire(evenementRequest.getHoraire());
        evenement.setPlacementLibre(evenementRequest.getPlacementLibre());
        return toDto(evenementRepository.save(evenement));
    }
    /**
     * Supprime un événement à partir de son identifiant.
     *
     * @param id L'identifiant de l'événement à supprimer.
     * @return EvenementResponseDto Les détails de l'événement supprimé.
     */
    public EvenementResponseDto deleteEvenementById(Long id) {
            Evenement evenement = evenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Événement non trouvé"));
            evenementRepository.deleteById(id);
            return toDto(evenement);
    }
}
