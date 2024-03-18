package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
