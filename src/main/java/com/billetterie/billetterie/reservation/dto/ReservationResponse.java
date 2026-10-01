package com.billetterie.billetterie.reservation.dto;

import com.billetterie.billetterie.client.ClientResponse;
import com.billetterie.billetterie.evenement.dto.EvenementResponse;
import com.billetterie.billetterie.status.StatutResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private Long id;
    private LocalDateTime dateCreation;
    private LocalDateTime datePaiement;
    private LocalDateTime dateAnnulation;
    private ClientResponse client;
    private BigDecimal montantTotal;
    private BigDecimal montantRembourse;
    private EvenementResponse evenement;
    private StatutResponse statut;
}

