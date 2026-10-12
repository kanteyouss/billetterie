package com.billetterie.billetterie.dto;

import com.billetterie.billetterie.utils.response.Response;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EvenementResponseDto implements ResponseDto {

    private Long id;
    private String titre;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horaire;
    private Boolean placementLibre;
    private SalleResponseDto salle;
}
