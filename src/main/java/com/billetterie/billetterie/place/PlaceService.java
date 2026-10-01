package com.billetterie.billetterie.place;

import com.billetterie.billetterie.categorie.Categorie;
import com.billetterie.billetterie.categorie.CategorieRepository;
import com.billetterie.billetterie.categorie.dto.CategorieResponse;
import com.billetterie.billetterie.place.dto.PlaceRequest;
import com.billetterie.billetterie.place.dto.PlaceResponse;
import com.billetterie.billetterie.salle.Salle;
import com.billetterie.billetterie.salle.SalleRepository;
import com.billetterie.billetterie.salle.dto.SalleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final SalleRepository salleRepository;
    private final CategorieRepository categorieRepository;

    public Place toEntity(PlaceRequest placeRequest, Salle salle, Categorie categorie) {
        return Place.builder()
                .numero(placeRequest.getNumero())
                .rang(placeRequest.getRang())
                .salle(salle)
                .categorie(categorie)
                .build();
    }
    private PlaceResponse toDto(Place place) {
        return PlaceResponse.builder()
                .id(place.getId())
                .numero(place.getNumero())
                .rang(place.getRang())
                .salle(SalleResponse.builder()
                        .id(place.getSalle().getId())
                        .capacite(place.getSalle().getCapacite())
                        .adresse(place.getSalle().getAdresse())
                        .build())
                .categorie(CategorieResponse.builder()
                        .id(place.getCategorie().getId())
                        .nom(place.getCategorie().getNom())
                        .description(place.getCategorie().getDescription())
                        .build())
                .build();
    }
    public List<PlaceResponse> getAllPlaces() {
        List <Place> places = placeRepository.findAll();
        if(places.isEmpty()){
            throw new RuntimeException("Auncune place n'a été trouvée");
        }
        return places.stream()
                .map(this::toDto)
                .toList();
    }

    public PlaceResponse getPlaceById(Long id) {
        Place place = placeRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Place non trouvée");
        });
        return toDto(place);
    }

    public PlaceResponse create(PlaceRequest placeRequest) {
        Salle salle = salleRepository.findById(placeRequest.getSalleId())
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Categorie categorie = categorieRepository.findById(placeRequest.getCategorieId())
                .orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Place place = toEntity(placeRequest, salle, categorie);
        return toDto(placeRepository.save(place));
    }

    public PlaceResponse updatePlace(Long id, PlaceRequest placeRequest) {
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

    public PlaceResponse deletePlaceByIdd(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place non trouvée"));
        placeRepository.deleteById(id);
        return toDto(place);
    }
}
