package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.entity.Categorie;
import com.billetterie.billetterie.service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/api/categorie")
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;
}
