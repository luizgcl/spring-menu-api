package br.com.luizgcl.menu.dtos.category;

import java.time.LocalDateTime;

public record ResponseCategoryDTO(
        String name,
        String slug,
        LocalDateTime createdAt
) {
}
