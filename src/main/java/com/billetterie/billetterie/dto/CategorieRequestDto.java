package com.billetterie.billetterie.dto;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategorieRequestDto implements RequestDto {
    private String nom;
    private String description;
}
