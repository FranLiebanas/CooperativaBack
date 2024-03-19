package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.InvoiceService;
import com.fran.cooperativa.backend.domain.model.Invoice;
import com.fran.cooperativa.backend.domain.request.CreateInvoiceRequest;
import com.fran.cooperativa.backend.infrastructure.exception.InvoiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {


    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<String> createInvoice(@RequestBody CreateInvoiceRequest request) {
        try {
            invoiceService.createInvoice(request.getInvoiceDate(), request.getOrderId(), request.getTotal(), request.getInvoiceStatus());
            return ResponseEntity.status(HttpStatus.CREATED).body("Factura creada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la factura");
        }
    }

    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long invoiceId) {
        try {
            invoiceService.deleteInvoice(invoiceId);
            return ResponseEntity.noContent().build();
        } catch (InvoiceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{invoiceId}/send")
    public ResponseEntity<Void> sendInvoice(@PathVariable Long invoiceId, @RequestParam String email) {
        try {
            invoiceService.sendInvoiceByEmail(invoiceId, email);
            return ResponseEntity.ok().build();
        } catch (InvoiceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}