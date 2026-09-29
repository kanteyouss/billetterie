package com.billetterie.billetterie.entity;

import jakarta.persistence.*;

/**
 * Représente la categorie de la place
 */
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length =30, nullable = false, unique = true)
    private String nom;
}