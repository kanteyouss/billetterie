package com.billetterie.billetterie.categorie;

import com.billetterie.billetterie.categorie.dto.CategorieRequest;
import com.billetterie.billetterie.categorie.dto.CategorieResponse;
import com.billetterie.billetterie.salle.SalleService;
import com.billetterie.billetterie.salle.dto.SalleResponse;
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
    public List<CategorieResponse> getAllCategories() {
        return categorieService.getAllCategories();
    }
    @PostMapping()
    private CategorieResponse createCategorie(@RequestBody CategorieRequest categorieRequest) {
        return categorieService.createCategorie(categorieRequest);
    }
    @GetMapping("/{id}")
    public CategorieResponse getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }
    @DeleteMapping("/{id}")
    public CategorieResponse deleteCategorieById(@PathVariable Long id) {
        return categorieService.deleteCategorieById(id);
    }
    @PutMapping("/{id}")
    public CategorieResponse updateCategorieById(@PathVariable Long id,@RequestBody CategorieRequest categorieRequest) {
        return categorieService.updateCategorieById(id, categorieRequest);
    }

}
