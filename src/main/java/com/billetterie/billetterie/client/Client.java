package com.billetterie.billetterie.client;

import jakarta.persistence.*;
import lombok.*;

/**
 * Représente le client qui fait une reservation por l'evenement
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nom;
    @Column(length = 20)
    private String prenom;
    @Column(length = 20)
    private String telephone;
}
