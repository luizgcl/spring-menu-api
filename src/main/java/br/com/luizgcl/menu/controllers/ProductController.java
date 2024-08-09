package br.com.luizgcl.menu.controllers;

import br.com.luizgcl.menu.dtos.product.CreateProductDTO;
import br.com.luizgcl.menu.dtos.product.ResponseProductDTO;
import br.com.luizgcl.menu.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{categoryId}")
    public ResponseEntity<List<ResponseProductDTO>> list(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(this.productService.listProductsByCategoryId(categoryId));
    }

    @PostMapping
    public ResponseEntity<ResponseProductDTO> create(@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(this.productService.createProduct(createProductDTO));
    }
}
