package com.billetterie.billetterie.client;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
}
