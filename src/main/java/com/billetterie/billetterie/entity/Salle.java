package com.billetterie.billetterie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int capacite;
    @Column(nullable = false)
    private String adresse;
}
