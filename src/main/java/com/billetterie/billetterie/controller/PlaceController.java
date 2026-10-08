    package com.billetterie.billetterie.controller;

    import com.billetterie.billetterie.dto.PlaceRequestDto;
    import com.billetterie.billetterie.dto.PlaceResponseDto;
    import com.billetterie.billetterie.service.PlaceService;
    import com.billetterie.billetterie.utils.response.Response;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/place")
    public class PlaceController extends CrudController{
        public PlaceController(PlaceService placeService) {
            super(placeService);
        }
    }