package com.billetterie.billetterie.evenement.dto;

import com.billetterie.billetterie.salle.dto.SalleResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EvenementResponse {

    private Long id;
    private String titre;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horaire;
    private Boolean placementLibre;
    private SalleResponse salle;
}
