package com.fran.cooperativa.backend.infrastructure.mapper;

import com.fran.cooperativa.backend.domain.model.Product;
import com.fran.cooperativa.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);
    Iterable<Product> toProductList(Iterable<ProductEntity> productEntities);
    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);

}
