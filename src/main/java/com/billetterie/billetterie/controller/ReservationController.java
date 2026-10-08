package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.ReservationRequestDto;
import com.billetterie.billetterie.dto.ReservationResponseDto;
import com.billetterie.billetterie.service.CrudService;
import com.billetterie.billetterie.service.ReservationService;
import com.billetterie.billetterie.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/reservation")
public class ReservationController extends CrudController {
    public  ReservationController(ReservationService reservationService) {
        super(reservationService);
    }
}