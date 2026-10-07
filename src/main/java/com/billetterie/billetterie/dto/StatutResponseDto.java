package com.billetterie.billetterie.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatutResponseDto {
    private Long id;
    private String libelle;
}
