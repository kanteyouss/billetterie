    package com.billetterie.billetterie.controller;

    import com.billetterie.billetterie.dto.PlaceRequestDto;
    import com.billetterie.billetterie.dto.PlaceResponseDto;
    import com.billetterie.billetterie.service.PlaceService;
    import com.billetterie.billetterie.utils.response.Response;
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
         * @return List<PlaceResponseDto> La liste des places.
         */
        @GetMapping
        public List<PlaceResponseDto> getAllPlaces() {
            return placeService.getAllPlaces();
        }

        /**
         * Récupère une place à partir de son identifiant.
         *
         * @param id L'identifiant de la place à récupérer.
         * @return PlaceResponseDto Les détails de la place récupérée.
         */
        @GetMapping("/{id}")
        public PlaceResponseDto getPlaceById(@PathVariable Long id) {
            return placeService.getPlaceById(id);
        }

        /**
         * Crée une nouvelle place.
         *
         * @param placeRequest Les données de la requête pour créer la place.
         * @return PlaceResponseDto Les détails de la place créée.
         */
        @PostMapping
        public PlaceResponseDto createPlace(@RequestBody PlaceRequestDto placeRequest) {
            return placeService.create(placeRequest);
        }

        /**
         * Modifie une place existante.
         *
         * @param id L'identifiant de la place à modifier.
         * @param placeRequest Les données de la requête pour modifier la place.
         * @return PlaceResponseDto Les détails de la place modifiée.
         */
        @PutMapping("/{id}")
        public PlaceResponseDto updatePlace(
                @PathVariable Long id,
                @RequestBody PlaceRequestDto placeRequest) {

            return placeService.updatePlace(id, placeRequest);
        }

        /**
         * Supprime une place à partir de son identifiant.
         *
         * @param id L'identifiant de la place à supprimer.
         * @return PlaceResponseDto Les détails de la place supprimée.
         */
        @DeleteMapping("/{id}")
        public PlaceResponseDto deletePlaceByIdd(@PathVariable Long id) {
            return placeService.deletePlaceByIdd(id);
        }
    }