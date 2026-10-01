package com.billetterie.billetterie.place.dto;

import com.billetterie.billetterie.categorie.dto.CategorieResponse;
import com.billetterie.billetterie.salle.Salle;
import com.billetterie.billetterie.salle.dto.SalleResponse;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceResponse {
    private Long id;
    private int rang;
    private int numero;
    private CategorieResponse categorie;
    private SalleResponse salle;
}
