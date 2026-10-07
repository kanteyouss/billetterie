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
    public Response<CategorieResponseDto> getAllCategories() {
        return new Response<>(categorieService.getAllCategories());
    }
    @PostMapping()
    private Response<CategorieResponseDto> createCategorie(@RequestBody CategorieRequestDto categorieRequest) {
        return new Response<>(categorieService.createCategorie(categorieRequest));
    }
    @GetMapping("/{id}")
    public Response<CategorieResponseDto> getCategorieById(@PathVariable Long id) {
        return new Response<>(categorieService.getCategorieById(id));
    }
    @DeleteMapping("/{id}")
    public Response<CategorieResponseDto> deleteCategorieById(@PathVariable Long id) {
        return new Response<>(categorieService.deleteCategorieById(id));
    }
    @PutMapping("/{id}")
    public Response<CategorieResponseDto> updateCategorieById(@PathVariable Long id,@RequestBody CategorieRequestDto categorieRequest) {
        return new Response<>(categorieService.updateCategorieById(id,categorieRequest));
    }

}
