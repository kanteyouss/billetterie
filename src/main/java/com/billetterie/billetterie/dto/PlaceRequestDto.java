package com.billetterie.billetterie.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRequestDto implements RequestDto{
    private int rang;
    private int numero;
    private Long salleId;
    private Long categorieId;
}
