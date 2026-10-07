package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.ReservationRequestDto;
import com.billetterie.billetterie.dto.ReservationResponseDto;
import com.billetterie.billetterie.service.ReservationService;
import com.billetterie.billetterie.utils.response.Response;
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
     * @return List<ReservationResponseDto> La liste des réservations.
     */
    @GetMapping
    public List<ReservationResponseDto> getAllReservations() {
        return reservationService.getAllReservations();
    }
    /**
     * Récupère une réservation à partir de son identifiant.
     *
     * @param id L'identifiant de la réservation à récupérer.
     * @return ReservationResponseDto Les détails de la réservation récupérée.
     */
    @GetMapping("/{id}")
    public Response<ReservationResponseDto> getReservationById(@PathVariable Long id) {
        return new Response<>(reservationService.getReservationById(id));
    }

    /**
     * Supprime une réservation à partir de son identifiant.
     *
     * @param id L'identifiant de la réservation à supprimer.
     * @return ReservationResponseDto Les détails de la réservation supprimée.
     */
    @DeleteMapping("/{id}")
    public ReservationResponseDto deleteById(@PathVariable Long id) {
        return reservationService.deleteById(id);
    }

    /**
     * Modifie une réservation existante.
     *
     * @param id L'identifiant de la réservation à modifier.
     * @param reservationRequest Les données de la requête pour modifier la réservation.
     * @return ReservationResponseDto Les détails de la réservation modifiée.
     */
    @PutMapping("/{id}")
    public ReservationResponseDto updateById(
            @PathVariable Long id,
            @RequestBody ReservationRequestDto reservationRequest) {

        return reservationService.updateById(id, reservationRequest);
    }
    /**
     * Crée une nouvelle réservation.
     *
     * @param reservationRequest Les données de la requête pour créer la réservation.
     * @return ReservationResponseDto Les détails de la réservation créée.
     */
    @PostMapping
    public ReservationResponseDto createById(@RequestBody ReservationRequestDto reservationRequest) {
        return reservationService.createById(reservationRequest);
    }
}