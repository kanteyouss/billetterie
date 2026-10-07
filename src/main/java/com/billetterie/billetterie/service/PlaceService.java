package com.billetterie.billetterie.service;

import com.billetterie.billetterie.entity.Categorie;
import com.billetterie.billetterie.entity.Place;
import com.billetterie.billetterie.repository.CategorieRepository;
import com.billetterie.billetterie.dto.CategorieResponseDto;
import com.billetterie.billetterie.dto.PlaceRequestDto;
import com.billetterie.billetterie.dto.PlaceResponseDto;
import com.billetterie.billetterie.repository.PlaceRepository;
import com.billetterie.billetterie.entity.Salle;
import com.billetterie.billetterie.repository.SalleRepository;
import com.billetterie.billetterie.dto.SalleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final SalleRepository salleRepository;
    private final CategorieRepository categorieRepository;

    public Place toEntity(PlaceRequestDto placeRequest, Salle salle, Categorie categorie) {
        return Place.builder()
                .numero(placeRequest.getNumero())
                .rang(placeRequest.getRang())
                .salle(salle)
                .categorie(categorie)
                .build();
    }
    private PlaceResponseDto toDto(Place place) {
        return PlaceResponseDto.builder()
                .id(place.getId())
                .numero(place.getNumero())
                .rang(place.getRang())
                .salle(SalleResponseDto.builder()
                        .id(place.getSalle().getId())
                        .capacite(place.getSalle().getCapacite())
                        .nom(place.getSalle().getNom())
                        .ville(place.getSalle().getVille())
                        .adresse(place.getSalle().getAdresse())
                        .build())
                .categorie(CategorieResponseDto.builder()
                        .id(place.getCategorie().getId())
                        .nom(place.getCategorie().getNom())
                        .description(place.getCategorie().getDescription())
                        .build())
                .build();
    }
    public List<PlaceResponseDto> getAllPlaces() {
        List <Place> places = placeRepository.findAll();
        if(places.isEmpty()){
            throw new RuntimeException("Auncune place n'a été trouvée");
        }
        return places.stream()
                .map(this::toDto)
                .toList();
    }

    public PlaceResponseDto getPlaceById(Long id) {
        Place place = placeRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Place non trouvée");
        });
        return toDto(place);
    }

    public PlaceResponseDto create(PlaceRequestDto placeRequest) {
        Salle salle = salleRepository.findById(placeRequest.getSalleId())
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Categorie categorie = categorieRepository.findById(placeRequest.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Place place = toEntity(placeRequest, salle, categorie);
        return toDto(placeRepository.save(place));
    }

    public PlaceResponseDto updatePlace(Long id, PlaceRequestDto placeRequest) {
        Salle salle = salleRepository.findById(placeRequest.getSalleId())
                .orElseThrow(() -> new RuntimeException("Salle non trouvée"));
        Categorie categorie = categorieRepository.findById(placeRequest.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Place place = placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Place non trouvée"));
        place.setNumero(placeRequest.getNumero());
        place.setRang(placeRequest.getRang());
        place.setSalle(salle);
        place.setCategorie(categorie);
        return toDto(placeRepository.save(place));

    }

    public PlaceResponseDto deletePlaceByIdd(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place non trouvée"));
        placeRepository.deleteById(id);
        return toDto(place);
    }
}
