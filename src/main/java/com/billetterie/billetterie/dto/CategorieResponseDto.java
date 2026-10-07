package com.billetterie.billetterie.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieResponseDto implements ResponseDto {
    private Long id;
    private String nom;
    private String description;
}
