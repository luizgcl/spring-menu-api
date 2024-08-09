package br.com.luizgcl.menu.dtos.category;

public record CreateCategoryDTO(
        String name,
        String description,
        String slug
) {
}
