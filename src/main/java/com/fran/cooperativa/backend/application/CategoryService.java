package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.Category;
import com.fran.cooperativa.backend.domain.port.ICategoryRepository;

public class CategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    public Iterable<Category> findALll() {
        return iCategoryRepository.findALL();
    }

    public Category findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    public void deleteById(Integer id) {
        iCategoryRepository.deleteById(id);
    }


}
