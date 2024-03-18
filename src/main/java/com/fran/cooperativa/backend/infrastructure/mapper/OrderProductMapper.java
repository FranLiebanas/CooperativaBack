package com.fran.cooperativa.backend.infrastructure.mapper;

import com.fran.cooperativa.backend.domain.model.OrderProduct;
import com.fran.cooperativa.backend.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "productId", target = "productId")

            }
    )


    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProductList(Iterable<OrderProductEntity>orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);

}
