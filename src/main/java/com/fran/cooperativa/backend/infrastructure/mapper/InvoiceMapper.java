package com.fran.cooperativa.backend.infrastructure.mapper;

import com.fran.cooperativa.backend.domain.model.Invoice;
import com.fran.cooperativa.backend.infrastructure.entity.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceEntity mapDtoToEntity(Invoice dto);

    Invoice mapEntityToDto(InvoiceEntity entity);
}