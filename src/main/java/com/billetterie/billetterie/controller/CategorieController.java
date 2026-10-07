package com.billetterie.billetterie.controller;

import com.billetterie.billetterie.service.CategorieService;
import com.billetterie.billetterie.dto.CategorieRequestDto;
import com.billetterie.billetterie.dto.CategorieResponseDto;
import com.billetterie.billetterie.service.SalleService;
import com.billetterie.billetterie.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorie")
public class CategorieController {
    private final SalleService salleService;
    private final CategorieService categorieService;
    @GetMapping
    public List<CategorieResponseDto> getAllCategories() {
        return categorieService.getAllCategories();
    }
    @PostMapping()
    private CategorieResponseDto createCategorie(@RequestBody CategorieRequestDto categorieRequest) {
        return  categorieService.createCategorie(categorieRequest);
    }
    @GetMapping("/{id}")
    public CategorieResponseDto getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }
    @DeleteMapping("/{id}")
    public CategorieResponseDto deleteCategorieById(@PathVariable Long id) {
        return categorieService.deleteCategorieById(id);
    }
    @PutMapping("/{id}")
    public CategorieResponseDto updateCategorieById(@PathVariable Long id,@RequestBody CategorieRequestDto categorieRequest) {
        return categorieService.updateCategorieById(id,categorieRequest);
    }

}
