package com.billetterie.billetterie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "statut")
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
}
