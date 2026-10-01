package com.billetterie.billetterie.categorie.dto;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategorieRequest {
    private String nom;
    private String description;
}
