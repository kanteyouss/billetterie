package com.billetterie.billetterie.place;

import com.billetterie.billetterie.categorie.Categorie;
import com.billetterie.billetterie.salle.Salle;
import jakarta.persistence.*;
import lombok.*;

/**
 * Représente la place dans la salle pour l'evenement
 */
@Entity
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
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
