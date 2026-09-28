package com.billetterie.billetterie.entity;

import jakarta.persistence.*;
/**
 * Représente l'evenement qui se deroule
 */
import java.time.LocalDateTime;
@Entity
@Table(name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private LocalDateTime horaire;
    @Column(name = "placement_libre")
    private Boolean placementLibre;


}
