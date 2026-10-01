package com.billetterie.billetterie.salle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"id","nom", "capacite", "adresse"})
public class SalleResponse {
    private Long id;
    private String nom;
    private int capacite;
    private String adresse;
}
