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
        public Response<PlaceResponseDto> getAllPlaces() {
            return new Response<>(placeService.getAllPlaces());
        }

        /**
         * Récupère une place à partir de son identifiant.
         *
         * @param id L'identifiant de la place à récupérer.
         * @return PlaceResponseDto Les détails de la place récupérée.
         */
        @GetMapping("/{id}")
        public Response<PlaceResponseDto> getPlaceById(@PathVariable Long id) {
            return new Response<>(placeService.getPlaceById(id));
        }

        /**
         * Crée une nouvelle place.
         *
         * @param placeRequest Les données de la requête pour créer la place.
         * @return PlaceResponseDto Les détails de la place créée.
         */
        @PostMapping
        public Response<PlaceResponseDto> createPlace(@RequestBody PlaceRequestDto placeRequest) {
            return new Response<>(placeService.create(placeRequest));
        }

        /**
         * Modifie une place existante.
         *
         * @param id L'identifiant de la place à modifier.
         * @param placeRequest Les données de la requête pour modifier la place.
         * @return PlaceResponseDto Les détails de la place modifiée.
         */
        @PutMapping("/{id}")
        public Response<PlaceResponseDto> updatePlace(
                @PathVariable Long id,
                @RequestBody PlaceRequestDto placeRequest) {

            return new Response<>(placeService.updatePlace(id, placeRequest));
        }

        /**
         * Supprime une place à partir de son identifiant.
         *
         * @param id L'identifiant de la place à supprimer.
         * @return PlaceResponseDto Les détails de la place supprimée.
         */
        @DeleteMapping("/{id}")
        public Response<PlaceResponseDto> deletePlaceByIdd(@PathVariable Long id) {
            return new Response<>(placeService.deletePlaceByIdd(id));
        }
    }