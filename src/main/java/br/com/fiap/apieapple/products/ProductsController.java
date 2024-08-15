package br.com.fiap.apieapple.products;

import br.com.fiap.apieapple.products.dto.ProductsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService service;

    @GetMapping
    public List<Products> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Products> create(@RequestBody ProductsRequest productsRequest, UriComponentsBuilder uriBuilder) {
        var products = service.create(productsRequest.toModel());

        var uri = uriBuilder
                .path("/products/{id}")
                .buildAndExpand(products.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(products);
    }

}
