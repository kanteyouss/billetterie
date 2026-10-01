package com.billetterie.billetterie.place;

import com.billetterie.billetterie.place.dto.PlaceRequest;
import com.billetterie.billetterie.place.dto.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    /**
     * Récupère la liste de toutes les places.
     *
     * @return List<PlaceResponse> La liste des places.
     */
    @GetMapping
    public List<PlaceResponse> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    /**
     * Récupère une place à partir de son identifiant.
     *
     * @param id L'identifiant de la place à récupérer.
     * @return PlaceResponse Les détails de la place récupérée.
     */
    @GetMapping("/{id}")
    public PlaceResponse getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    /**
     * Crée une nouvelle place.
     *
     * @param placeRequest Les données de la requête pour créer la place.
     * @return PlaceResponse Les détails de la place créée.
     */
    @PostMapping
    public PlaceResponse createPlace(@RequestBody PlaceRequest placeRequest) {
        return placeService.create(placeRequest);
    }

    /**
     * Modifie une place existante.
     *
     * @param id L'identifiant de la place à modifier.
     * @param placeRequest Les données de la requête pour modifier la place.
     * @return PlaceResponse Les détails de la place modifiée.
     */
    @PutMapping("/{id}")
    public PlaceResponse updatePlace(
            @PathVariable Long id,
            @RequestBody PlaceRequest placeRequest) {

        return placeService.updatePlace(id, placeRequest);
    }

    /**
     * Supprime une place à partir de son identifiant.
     *
     * @param id L'identifiant de la place à supprimer.
     * @return PlaceResponse Les détails de la place supprimée.
     */
    @DeleteMapping("/{id}")
    public PlaceResponse deletePlaceByIdd(@PathVariable Long id) {
        return placeService.deletePlaceByIdd(id);
    }
}