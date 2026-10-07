package com.billetterie.billetterie.service;

import com.billetterie.billetterie.dto.CategorieRequestDto;
import com.billetterie.billetterie.dto.CategorieResponseDto;
import com.billetterie.billetterie.entity.Categorie;
import com.billetterie.billetterie.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepository categorieRepository;
    private CategorieResponseDto categorieResponse;
    private CategorieRequestDto categorieRequest;

    public Categorie toEntity(CategorieRequestDto categorieRequest) {
        return Categorie.builder()
                .nom(categorieRequest.getNom())
                .description(categorieRequest.getDescription())
                .build();
    }
    public CategorieResponseDto toDto(Categorie categorie) {
        return CategorieResponseDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }
        public List<CategorieResponseDto> getAllCategories() {
        List<Categorie>categories = categorieRepository.findAll();
            return categories.stream()
                    .map(this::toDto)
                    .toList();
        }
    public CategorieResponseDto createCategorie(CategorieRequestDto categorieRequest) {
        Categorie categorieSauvegardee = categorieRepository.save(toEntity(categorieRequest));
        return toDto(categorieSauvegardee);
    }
    public CategorieResponseDto getCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        return toDto(categorie);
    }
    public CategorieResponseDto deleteCategorieById(Long id) {
        if(!categorieRepository.existsById(id)){
            throw new RuntimeException("Categorie non trouvée");
        } else {
            Optional<Categorie> categorie = categorieRepository.findById(id);
            categorieRepository.deleteById(id);
            return toDto(categorie.get());
        }
    }
    public CategorieResponseDto updateCategorieById(Long id, CategorieRequestDto categorieRequest) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        categorie.setNom(categorieRequest.getNom());
        categorie.setDescription(categorieRequest.getDescription());
        categorieRepository.save(categorie);
        return toDto(categorie);
    }
}