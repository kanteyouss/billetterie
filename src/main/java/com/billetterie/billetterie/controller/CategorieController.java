    package com.billetterie.billetterie.controller;

    import com.billetterie.billetterie.service.AbstractCrudService;
    import com.billetterie.billetterie.service.CategorieService;
    import com.billetterie.billetterie.dto.CategorieRequestDto;
    import com.billetterie.billetterie.dto.CategorieResponseDto;
    import com.billetterie.billetterie.service.CrudService;
    import com.billetterie.billetterie.service.SalleService;
    import com.billetterie.billetterie.utils.response.Response;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/categorie")
    public class CategorieController extends CrudController {
        public CategorieController(CategorieService categorieService) {
            super(categorieService);
        }
    }
