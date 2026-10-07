package com.billetterie.billetterie.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceResponseDto {
    private Long id;
    private int rang;
    private int numero;
    private CategorieResponseDto categorie;
    private SalleResponseDto salle;
}
