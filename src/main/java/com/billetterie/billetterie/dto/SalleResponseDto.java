package com.billetterie.billetterie.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"id","nom", "ville", "capacite", "adresse"})
public class SalleResponseDto implements ResponseDto{
    private Long id;
    private String nom;
    private String ville;
    private int capacite;
    private String adresse;
}
