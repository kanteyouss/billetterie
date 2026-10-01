package com.billetterie.billetterie.salle.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SalleRequest {
    private String nom;
    private int capacite;
    private String adresse;
}
