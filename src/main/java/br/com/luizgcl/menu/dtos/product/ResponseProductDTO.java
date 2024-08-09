package br.com.luizgcl.menu.dtos.product;

import br.com.luizgcl.menu.entities.Category;

import java.time.LocalDateTime;

public record ResponseProductDTO(
        String name,
        String sku,
        String slug,
        Double cost,
        Double price,
        String categoryName,
        LocalDateTime createdAt
) {
}
