package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
