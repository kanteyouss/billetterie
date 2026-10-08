package com.billetterie.billetterie.controller;


import com.billetterie.billetterie.service.CrudService;
import com.billetterie.billetterie.service.EvenementService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")

public class EvenementController extends CrudController {
    public EvenementController(EvenementService evenementService) {
       super(evenementService);
    }
}
