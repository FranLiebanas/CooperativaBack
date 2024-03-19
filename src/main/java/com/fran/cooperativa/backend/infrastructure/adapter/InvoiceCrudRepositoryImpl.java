package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.domain.model.Invoice;
import com.fran.cooperativa.backend.domain.port.IInvoiceRepository;
import com.fran.cooperativa.backend.infrastructure.mapper.InvoiceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InvoiceCrudRepositoryImpl implements IInvoiceRepository {

    private final IInvoiceCrudRepository invoiceCrudRepository;

    public InvoiceCrudRepositoryImpl(IInvoiceCrudRepository invoiceCrudRepository) {
        this.invoiceCrudRepository = invoiceCrudRepository;
    }

    @Override
    public void createInvoice(Invoice invoice) {

        var invoiceEntity = InvoiceMapper.INSTANCE.mapDtoToEntity(invoice);

        invoiceCrudRepository.save(invoiceEntity);
    }

    @Override
    public void deleteInvoice(Long invoiceId) {
        invoiceCrudRepository.deleteById(invoiceId);
    }

    @Override
    public void sendInvoiceByEmail(Long invoiceId, String email) {
        // Implementación para enviar la factura por correo electrónico
    }
}
