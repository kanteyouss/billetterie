package com.billetterie.billetterie.evenement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EvenementRequest {
    private Long id;
    private String titre;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime horaire;
    private Boolean placementLibre;
    private Long salleId;
}
