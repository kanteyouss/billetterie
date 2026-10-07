package com.billetterie.billetterie.service;

import com.billetterie.billetterie.dto.SalleRequestDto;
import com.billetterie.billetterie.dto.SalleResponseDto;
import com.billetterie.billetterie.entity.Salle;
import com.billetterie.billetterie.repository.SalleRepository;
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

    public Salle toEntity(SalleRequestDto salleRequest) {
        return Salle.builder()
                .capacite(salleRequest.getCapacite())
                .nom(salleRequest.getNom())
                .ville(salleRequest.getVille())
                .adresse(salleRequest.getAdresse())
                .build();
    }
    public SalleResponseDto toDto(Salle salle) {
        return SalleResponseDto.builder()
                .id(salle.getId())
                .nom(salle.getNom())
                .ville(salle.getVille())
                .capacite(salle.getCapacite())
                .adresse(salle.getAdresse())
                .build();
    }
    public List<SalleResponseDto> getAllSalle() {
        return salleRepository.findAll().stream()
                .map(salle -> toDto(salle))
                .toList();
    }

    public SalleResponseDto createSalle(SalleRequestDto salleRequest) {
        Salle salle = salleRepository.save(toEntity(salleRequest));
        return toDto(salle);
    }

    public SalleResponseDto getSalleById(Long id) {
        Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
        return toDto(salle);
    }

    public SalleResponseDto updatesalle(Long id, SalleRequestDto salleRequest) {
            Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
            salle.setNom(salleRequest.getNom());
            salle.setVille(salleRequest.getVille());
            salle.setCapacite(salleRequest.getCapacite());
            salle.setAdresse(salleRequest.getAdresse());
            salleRepository.save(salle);
            return toDto(salle);
    }

    public SalleResponseDto deleteSalle(Long id) {
            Salle salle = salleRepository.findById(id).orElseThrow(() -> new RuntimeException("Salle non trouvée"));
            salleRepository.deleteById(id);
            return toDto(salle);
    }
}
