package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.CategoryService;
import com.fran.cooperativa.backend.domain.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/categories")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity <Category> save(@RequestBody Category category){

        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <Iterable<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findALll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> findByid(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){

        categoryService.deleteById(id);

        return ResponseEntity.ok().build();
    }
// no hacemos update porque lo hace el save auto si tiene id hace el update y sino le asigna uno nuevo
}
