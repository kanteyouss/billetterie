package com.billetterie.billetterie.service;

import com.billetterie.billetterie.dto.CategorieRequestDto;
import com.billetterie.billetterie.dto.CategorieResponseDto;
import com.billetterie.billetterie.dto.RequestDto;
import com.billetterie.billetterie.dto.ResponseDto;
import com.billetterie.billetterie.entity.Categorie;
import com.billetterie.billetterie.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
@Service
public class CategorieService extends AbstractCrudService {

    private JpaRepository jpaRepository;
    private CategorieResponseDto categorieResponse;
    private CategorieRequestDto categorieRequest;
    private final CategorieRepository categorieRepository;
    public CategorieService(CategorieRepository categorieRepository) {
        super(categorieRepository);
        this.categorieRepository = categorieRepository;
    }

    public Categorie toEntity(CategorieRequestDto CategorieRequestDto) {
        return Categorie.builder()
                .nom(categorieRequest.getNom())
                .description(categorieRequest.getDescription())
                .build();
    }
    @Override
    public ResponseDto toDto(Object entity) {
        Categorie categorie = (Categorie) entity;
        return CategorieResponseDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }
  @Override
    public ResponseDto create(RequestDto request) {
        CategorieRequestDto categorieRequest = (CategorieRequestDto) request;
        Categorie categorieSauvegardee = categorieRepository.save(toEntity(categorieRequest));
        return toDto(categorieSauvegardee);
    }

    @Override
    public ResponseDto update(Long id, RequestDto requestDto) {
        CategorieRequestDto categorieRequest = (CategorieRequestDto) requestDto;
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
            categorie.setNom(categorieRequest.getNom());
            categorie.setDescription(categorieRequest.getDescription());
        categorieRepository.save(categorie);
        return toDto(categorie);
    }
}