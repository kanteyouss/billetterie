package com.billetterie.billetterie.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * Représente le paiement d'une reservation
 */
@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal montant;

    @Column(name = "date_paiement", nullable = false)
    private LocalDateTime datePaiement;

    @Column(length = 50)
    private String modePaiement; // ex: 'Carte', 'Espèces', 'Mobile Money'

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Reservation reservation;
}