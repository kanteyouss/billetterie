package com.billetterie.billetterie.place.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRequest {
    private int rang;
    private int numero;
    private Long salleId;
    private Long categorieId;
}
