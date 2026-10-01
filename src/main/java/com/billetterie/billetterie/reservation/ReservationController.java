package com.billetterie.billetterie.reservation;

import com.billetterie.billetterie.reservation.dto.ReservationRequest;
import com.billetterie.billetterie.reservation.dto.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Récupère la liste de toutes les réservations.
     *
     * @return List<ReservationResponse> La liste des réservations.
     */
    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationService.getAllReservations();
    }

    /**
     * Récupère une réservation à partir de son identifiant.
     *
     * @param id L'identifiant de la réservation à récupérer.
     * @return ReservationResponse Les détails de la réservation récupérée.
     */
    @GetMapping("/{id}")
    public ReservationResponse getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    /**
     * Supprime une réservation à partir de son identifiant.
     *
     * @param id L'identifiant de la réservation à supprimer.
     * @return ReservationResponse Les détails de la réservation supprimée.
     */
    @DeleteMapping("/{id}")
    public ReservationResponse deleteById(@PathVariable Long id) {
        return reservationService.deleteById(id);
    }

    /**
     * Modifie une réservation existante.
     *
     * @param id L'identifiant de la réservation à modifier.
     * @param reservationRequest Les données de la requête pour modifier la réservation.
     * @return ReservationResponse Les détails de la réservation modifiée.
     */
    @PutMapping("/{id}")
    public ReservationResponse updateById(
            @PathVariable Long id,
            @RequestBody ReservationRequest reservationRequest) {

        return reservationService.updateById(id, reservationRequest);
    }

    /**
     * Crée une nouvelle réservation.
     *
     * @param reservationRequest Les données de la requête pour créer la réservation.
     * @return ReservationResponse Les détails de la réservation créée.
     */
    @PostMapping
    public ReservationResponse createById(
            @RequestBody ReservationRequest reservationRequest) {

        return reservationService.createById(reservationRequest);
    }
}