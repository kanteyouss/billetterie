package com.billetterie.billetterie.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rang;
    private int numero;
    @ManyToOne()
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;
    @ManyToOne
    @JoinColumn(name = "categorie_id",nullable = false)
    private Categorie categorie;

}
