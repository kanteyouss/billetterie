package com.billetterie.billetterie.reservation;

import com.billetterie.billetterie.client.Client;
import com.billetterie.billetterie.client.ClientRepository;
import com.billetterie.billetterie.client.ClientResponse;
import com.billetterie.billetterie.evenement.Evenement;
import com.billetterie.billetterie.evenement.EvenementRepository;
import com.billetterie.billetterie.evenement.dto.EvenementResponse;
import com.billetterie.billetterie.reservation.dto.ReservationRequest;
import com.billetterie.billetterie.reservation.dto.ReservationResponse;
import com.billetterie.billetterie.status.Statut;
import com.billetterie.billetterie.status.StatutRepository;
import com.billetterie.billetterie.status.StatutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private  final ReservationRepository reservationRepository;
    private final StatutRepository statutRepository;
    private final EvenementRepository evenementRepository;
    private final ClientRepository clientRepository;
    public Reservation toEntity(ReservationRequest reservationRequest , Statut statut, Client client,Evenement evenement)  {
        return Reservation.builder()
                .dateCreation(reservationRequest.getDateCreation())
                .datePaiement(reservationRequest.getDatePaiement())
                .dateAnnulation(reservationRequest.getDateAnnulation())
                .client(client)
                .montantTotal(reservationRequest.getMontantTotal())
                .montantRembourse(reservationRequest.getMontantRembourse())
                .statut(statut)
                .evenement(evenement)
                .build();
    }

    public ReservationResponse toDto(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .dateCreation(reservation.getDateCreation())
                .datePaiement(reservation.getDatePaiement())
                .dateAnnulation(reservation.getDateAnnulation())
                .montantTotal(reservation.getMontantTotal())
                .montantRembourse(reservation.getMontantRembourse())
                .client(ClientResponse.builder()
                                .id(reservation.getClient().getId())
                                .nom(reservation.getClient().getNom())
                                .prenom(reservation.getClient().getPrenom())
                                .telephone(reservation.getClient().getTelephone())
                                .build()
                ).evenement(EvenementResponse.builder()
                                .id(reservation.getEvenement().getId())
                        .titre(reservation.getEvenement().getTitre())
                        .description(reservation.getEvenement().getDescription())
                        .horaire(reservation.getEvenement().getHoraire())
                        .placementLibre(reservation.getEvenement().getPlacementLibre())
                        .build()
                ).statut(StatutResponse.builder()
                                .id(reservation.getStatut().getId())
                                .libelle(reservation.getStatut().getLibelle())
                                .build()
                ).build();
    }

    public List<ReservationResponse> getAllReservations() {
        Reservation reservation = reservationRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune réservation trouvée"));
        return reservationRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }
    public ReservationResponse getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        return toDto(reservation);
    }

    public ReservationResponse deleteById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservationRepository.deleteById(id);
        return toDto(reservation);
    }

    public ReservationResponse updateById(Long id,ReservationRequest reservationRequest) {
        Statut statut = statutRepository.findById(reservationRequest.getStatutId())
                .orElseThrow(() -> new RuntimeException("Statut non trouvé"));
        Client client = clientRepository.findById(reservationRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Evenement evenement = evenementRepository.findById(reservationRequest.getEvenementId())
                .orElseThrow(() -> new RuntimeException("Événement non trouvé"));
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservation.setDatePaiement(reservationRequest.getDatePaiement());
        reservation.setDateAnnulation(reservationRequest.getDateAnnulation());
        reservation.setMontantTotal(reservationRequest.getMontantTotal());
        reservation.setMontantRembourse(reservationRequest.getMontantRembourse());
        reservation.setStatut(statut);
        reservation.setClient(client);
        reservation.setEvenement(evenement);
        return toDto(reservationRepository.save(reservation));
    }

    public ReservationResponse createById(ReservationRequest reservationRequest) {
        Statut statut = statutRepository.findById(reservationRequest.getStatutId())
                .orElseThrow(() -> new RuntimeException("Statut non trouvé"));
        Client client = clientRepository.findById(reservationRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Evenement evenement = evenementRepository.findById(reservationRequest.getEvenementId())
                .orElseThrow(() -> new RuntimeException("Événement non trouvé"));
        Reservation reservation = toEntity(reservationRequest,statut, client, evenement);
        return toDto(reservationRepository.save(reservation));
    }
}
