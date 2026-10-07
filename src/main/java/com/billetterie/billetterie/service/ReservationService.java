package com.billetterie.billetterie.service;

import com.billetterie.billetterie.entity.Client;
import com.billetterie.billetterie.entity.Reservation;
import com.billetterie.billetterie.repository.ClientRepository;
import com.billetterie.billetterie.dto.ClientResponseDto;
import com.billetterie.billetterie.entity.Evenement;
import com.billetterie.billetterie.repository.EvenementRepository;
import com.billetterie.billetterie.dto.EvenementResponseDto;
import com.billetterie.billetterie.dto.ReservationRequestDto;
import com.billetterie.billetterie.dto.ReservationResponseDto;
import com.billetterie.billetterie.repository.ReservationRepository;
import com.billetterie.billetterie.entity.Statut;
import com.billetterie.billetterie.repository.StatutRepository;
import com.billetterie.billetterie.dto.StatutResponseDto;
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
    public Reservation toEntity(ReservationRequestDto reservationRequest , Statut statut, Client client, Evenement evenement)  {
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

    public ReservationResponseDto toDto(Reservation reservation) {
        return ReservationResponseDto.builder()
                .id(reservation.getId())
                .dateCreation(reservation.getDateCreation())
                .datePaiement(reservation.getDatePaiement())
                .dateAnnulation(reservation.getDateAnnulation())
                .montantTotal(reservation.getMontantTotal())
                .montantRembourse(reservation.getMontantRembourse())
                .client(ClientResponseDto.builder()
                                .id(reservation.getClient().getId())
                                .nom(reservation.getClient().getNom())
                                .prenom(reservation.getClient().getPrenom())
                                .telephone(reservation.getClient().getTelephone())
                                .build()
                ).evenement(EvenementResponseDto.builder()
                                .id(reservation.getEvenement().getId())
                        .titre(reservation.getEvenement().getTitre())
                        .description(reservation.getEvenement().getDescription())
                        .horaire(reservation.getEvenement().getHoraire())
                        .placementLibre(reservation.getEvenement().getPlacementLibre())
                        .build()
                ).statut(StatutResponseDto.builder()
                                .id(reservation.getStatut().getId())
                                .libelle(reservation.getStatut().getLibelle())
                                .build()
                ).build();
    }

    public List<ReservationResponseDto> getAllReservations() {
        Reservation reservation = reservationRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucune réservation trouvée"));
        return reservationRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }
    public ReservationResponseDto getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        return toDto(reservation);
    }

    public ReservationResponseDto deleteById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        reservationRepository.deleteById(id);
        return toDto(reservation);
    }

    public ReservationResponseDto updateById(Long id,ReservationRequestDto reservationRequest) {
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

    public ReservationResponseDto createById(ReservationRequestDto reservationRequest) {
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
