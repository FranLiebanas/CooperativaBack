package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.Invoice;
import com.fran.cooperativa.backend.domain.port.IInvoiceRepository;

import java.util.Date;

public class InvoiceService {

    private final IInvoiceRepository iInvoiceRepository;

    public InvoiceService(IInvoiceRepository iInvoiceRepository) {
        this.iInvoiceRepository = iInvoiceRepository;
    }

    public void createInvoice(Date invoiceDate, Long orderId, Double total, String invoiceStatus) {
        Invoice invoice = Invoice.of(invoiceDate, orderId, total, invoiceStatus);
        iInvoiceRepository.createInvoice(invoice);
    }

    public void deleteInvoice(Long invoiceId) {
        iInvoiceRepository.deleteInvoice(invoiceId);
    }

    public void sendInvoiceByEmail(Long invoiceId, String email) {
        // Aquí iría la lógica para enviar la factura por correo electrónico
        // Por ejemplo, puedes llamar a un servicio externo para enviar el correo electrónico
        // También podrías generar un PDF con la factura y adjuntarlo al correo
    }

}
