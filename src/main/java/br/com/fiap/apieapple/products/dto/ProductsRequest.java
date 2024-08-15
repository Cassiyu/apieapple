package br.com.fiap.apieapple.products.dto;

import br.com.fiap.apieapple.products.Products;

public record ProductsRequest(
        String name,
        String description,
        String image,
        String tag,
        Long price
) {
    public Products toModel() {
        return Products.builder()
                .name(name)
                .description(description)
                .image(image)
                .tag(tag)
                .price(price)
                .build();
    }
}