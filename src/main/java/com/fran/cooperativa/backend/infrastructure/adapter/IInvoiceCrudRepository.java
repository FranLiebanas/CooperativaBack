package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.infrastructure.entity.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface IInvoiceCrudRepository extends CrudRepository<InvoiceEntity, Long> {
}
