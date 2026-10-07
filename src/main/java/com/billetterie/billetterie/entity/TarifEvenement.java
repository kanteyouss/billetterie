package com.billetterie.billetterie.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
/**
 * Représente  la tabe associative entre evenement et categorie avec le prix
 */
@Entity
@Table(name = "tarif_evenement")
public class TarifEvenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal prix;
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
//    @ManyToOne
//    @JoinColumn(name = "categorie_id")
//    private Categorie categorie;
}
