package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.Category;

public interface ICategoryRepository {
    Category save (Category category);
    Iterable<Category> findALL();
    Category findById(Integer id);
    void deleteById(Integer id);
}
