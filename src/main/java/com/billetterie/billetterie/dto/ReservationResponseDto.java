package com.billetterie.billetterie.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {
    private Long id;
    private LocalDateTime dateCreation;
    private LocalDateTime datePaiement;
    private LocalDateTime dateAnnulation;
    private ClientResponseDto client;
    private BigDecimal montantTotal;
    private BigDecimal montantRembourse;
    private EvenementResponseDto evenement;
    private StatutResponseDto statut;
}

