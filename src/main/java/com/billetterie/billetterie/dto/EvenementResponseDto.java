package com.billetterie.billetterie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EvenementResponseDto {

    private Long id;
    private String titre;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horaire;
    private Boolean placementLibre;
    private SalleResponseDto salle;
}
