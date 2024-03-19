package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.Invoice;
import com.fran.cooperativa.backend.infrastructure.entity.InvoiceEntity;

public interface IInvoiceRepository {

    /**
     * Registra una nueva factura.
     *
     * @param invoice La factura a ser registrada.
     */
    void createInvoice(Invoice invoice);

    /**
     * Realiza un borrado lógico de la factura.
     *
     * @param invoiceId El ID de la factura a ser eliminada.
     */
    void deleteInvoice(Long invoiceId);

    /**
     * Envía la factura por correo electrónico al cliente.
     *
     * @param invoiceId El ID de la factura a ser enviada por correo electrónico.
     * @param email     El correo electrónico del cliente.
     */
    void sendInvoiceByEmail(Long invoiceId, String email);
}
