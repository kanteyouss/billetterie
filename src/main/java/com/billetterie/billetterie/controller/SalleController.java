package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.dto.SalleRequestDto;
import com.billetterie.billetterie.dto.SalleResponseDto;
import com.billetterie.billetterie.service.SalleService;
import com.billetterie.billetterie.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController extends CrudController {
    public SalleController(SalleService salleService) {
        super(salleService);
    }
}