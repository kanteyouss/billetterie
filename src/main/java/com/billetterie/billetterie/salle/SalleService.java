package com.billetterie.billetterie.salle;

import com.billetterie.billetterie.salle.dto.SalleRequest;
import com.billetterie.billetterie.salle.dto.SalleResponse;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Représente la salle de evenement
 */
@Service
@RequiredArgsConstructor
public class SalleService {
    private final SalleRepository salleRepository;

    public Salle toEntity(SalleRequest salleRequest) {
        return Salle.builder()
                .capacite(salleRequest.getCapacite())
                .nom(salleRequest.getNom())
                .adresse(salleRequest.getAdresse())
                .build();
    }
    public SalleResponse toDto(Salle salle) {
        return SalleResponse.builder()
                .id(salle.getId())
                .nom(salle.getNom())
                .capacite(salle.getCapacite())
                .adresse(salle.getAdresse())
                .build();
    }
    public List<SalleResponse> getAllSalle() {
        return salleRepository.findAll().stream()
                .map(salle -> toDto(salle))
                .toList();
    }

    public SalleResponse createSalle(SalleRequest salleRequest) {
        Salle salle = salleRepository.save(toEntity(salleRequest));
        return toDto(salle);
    }

    public SalleResponse getSalleById(Long id) {
        Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
        return toDto(salle);
    }

    public SalleResponse updatesalle(Long id, SalleRequest salleRequest) {
            Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
            salle.setCapacite(salleRequest.getCapacite());
            salle.setAdresse(salleRequest.getAdresse());
            salleRepository.save(salle);
            return toDto(salle);
    }

    public SalleResponse deleteSalle(Long id) {
            Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
            salleRepository.deleteById(id);
            return toDto(salle);
    }
}
