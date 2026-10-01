package com.billetterie.billetterie.status;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatutResponse {
    private Long id;
    private String libelle;
}
