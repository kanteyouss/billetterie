package com.billetterie.billetterie.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
}
