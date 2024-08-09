package br.com.luizgcl.menu.dtos.product;

public record CreateProductDTO(
        String name,
        String sku,
        String slug,
        Integer categoryId,
        Double cost,
        Double price
) {
}
