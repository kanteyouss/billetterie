package com.billetterie.billetterie.evenement;

import com.billetterie.billetterie.categorie.Categorie;
import com.billetterie.billetterie.evenement.dto.EvenementRequest;
import com.billetterie.billetterie.evenement.dto.EvenementResponse;
import com.billetterie.billetterie.salle.Salle;
import com.billetterie.billetterie.salle.SalleRepository;
import com.billetterie.billetterie.salle.dto.SalleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
public class EvenementService {
    private final EvenementRepository evenementRepository;
    private final SalleRepository salleRepository;

    /**
     * Convertit une entité événement en objet de réponse.
     *
     * @param evenement L'entité événement à convertir.
     * @return EvenementResponse Les détails de l'événement converti.
     */
    public EvenementResponse toDto(Evenement evenement) {
        return EvenementResponse.builder()
                .id(evenement.getId())
                .titre(evenement.getTitre())
                .description(evenement.getDescription())
                .horaire(evenement.getHoraire())
                .placementLibre(evenement.getPlacementLibre())
                .salle(SalleResponse.builder()
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
    public Evenement toEntity(EvenementRequest evenementRequest, Salle salle) {
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
    public EvenementResponse createEvenement(EvenementRequest evenementRequest) {
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
     * @return EvenementResponse Les détails de l'événement récupéré.
     */
    public EvenementResponse getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Événement non trouvé"));
        return toDto(evenement);
    }
    /**
     * Récupère la liste de tous les événements.
     *
     * @return List<EvenementResponse> La liste des événements.
     */

    public List<EvenementResponse> getAllEvenements() {
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
     * @return EvenementResponse Les détails de l'événement modifié.
     */
    public EvenementResponse updateEvenementById(Long id, EvenementRequest evenementRequest) {
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
     * @return EvenementResponse Les détails de l'événement supprimé.
     */
    public EvenementResponse deleteEvenementById(Long id) {
            Evenement evenement = evenementRepository.findById(id).orElseThrow(() -> new RuntimeException("Événement non trouvé"));
            evenementRepository.deleteById(id);
            return toDto(evenement);
    }
}
