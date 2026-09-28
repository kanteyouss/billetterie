package com.billetterie.billetterie.entity;

import jakarta.persistence.*;
/**
 * Représente le client qui fait une reservation por l'evenement
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nom;
    @Column(length = 20)
    private String telephone;
}
