package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Invoice information for end customer invoices.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class InvoiceInformation
{
    /** The invoice date for the end customer invoice in format "YYYY-MM-DD" ISO-8601 (CET/CEST).
     * If not set, the order date will be used. */
    private String invoiceDate;

    /** The due date of the invoice for the end customer in format "YYYY-MM-DD" ISO-8601 (CET/CEST).
     * If not set, the invoice date plus 20 days will be used. */
    private String dueDate;

    /** Additional free text on the invoice */
    private String additionalInvoiceText;

    /** Information for the payment slip. Required when payment type is invoice. */
    private EsrInformation esrInformation;
}
