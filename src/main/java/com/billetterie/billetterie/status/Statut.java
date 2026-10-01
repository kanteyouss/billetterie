package com.billetterie.billetterie.status;

import jakarta.persistence.*;
import lombok.*;

/**
 * Représente  le statut de la reservation
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "statut")

public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
}