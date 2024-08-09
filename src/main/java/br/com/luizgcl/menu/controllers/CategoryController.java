package br.com.luizgcl.menu.controllers;

import br.com.luizgcl.menu.dtos.category.CreateCategoryDTO;
import br.com.luizgcl.menu.dtos.category.ResponseCategoryDTO;
import br.com.luizgcl.menu.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDTO>> list() {
        return ResponseEntity.ok(this.categoryService.listCategories());
    }

    @PostMapping
    public ResponseEntity<ResponseCategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO) {
        return ResponseEntity.ok(this.categoryService.createCategory(createCategoryDTO));
    }
}
