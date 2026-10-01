package com.billetterie.billetterie.categorie;

import com.billetterie.billetterie.categorie.dto.CategorieRequest;
import com.billetterie.billetterie.categorie.dto.CategorieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepository categorieRepository;
    private CategorieResponse categorieResponse;
    private CategorieRequest categorieRequest;

    public Categorie toEntity(CategorieRequest categorieRequest) {
        return Categorie.builder()
                .nom(categorieRequest.getNom())
                .description(categorieRequest.getDescription())
                .build();
    }
    public CategorieResponse toDto(Categorie categorie) {
        return CategorieResponse.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }
        public List<CategorieResponse> getAllCategories() {
        List<Categorie>categories = categorieRepository.findAll();
            return categories.stream()
                    .map(this::toDto)
                    .toList();
        }
    public CategorieResponse createCategorie(CategorieRequest categorieRequest) {
        Categorie categorieSauvegardee = categorieRepository.save(toEntity(categorieRequest));
        return toDto(categorieSauvegardee);
    }
    public CategorieResponse getCategorieById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        return toDto(categorie);
    }
    public CategorieResponse deleteCategorieById(Long id) {
        if(!categorieRepository.existsById(id)){
            throw new RuntimeException("Categorie non trouvée");
        } else {
            Optional<Categorie> categorie = categorieRepository.findById(id);
            categorieRepository.deleteById(id);
            return toDto(categorie.get());
        }
    }
    public CategorieResponse updateCategorieById(Long id, CategorieRequest categorieRequest) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        categorie.setNom(categorieRequest.getNom());
        categorie.setDescription(categorieRequest.getDescription());
        categorieRepository.save(categorie);
        return toDto(categorie);
    }
}