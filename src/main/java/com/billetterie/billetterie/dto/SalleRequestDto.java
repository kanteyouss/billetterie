package com.billetterie.billetterie.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SalleRequestDto implements RequestDto{
    private String nom;
    private String ville;
    private int capacite;
    private String adresse;
}
