package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.ProductService;
import com.fran.cooperativa.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("api/admin/products")
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestParam("id") Integer id,
                                        @RequestParam("code") String code,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("price") BigDecimal price,
                                        @RequestParam("urlImage") String urlImage,
                                        @RequestParam("stock") Integer stock,
                                        @RequestParam("stock_min") Integer stockMin,
                                        @RequestParam("stock_max") Integer stockMax,
                                        @RequestParam("dateCreated") String dateCreated,
                                        @RequestParam("dateUpdated") String dateUpdated,
                                        @RequestParam("categoryId") Integer categoryId,
                                        @RequestParam(value = "image", required = false) MultipartFile multipartFile)
            throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setUrlImage(urlImage);
        product.setStock(stock);
        product.setStock_min(stockMin);
        product.setStock_max(stockMax);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        try {
            product.setDateCreated(LocalDateTime.parse(dateCreated, formatter));
            product.setDateUpdated(LocalDateTime.parse(dateUpdated, formatter));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use the ISO format: yyyy-MM-dd'T'HH:mm:ss", e);
        }

        product.setCategoryId(categoryId);

        log.info("Nombre producto: {}", product.getName());

        // Pass both product and multipartFile to the save method
        return new ResponseEntity<>(productService.save(product, multipartFile), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
